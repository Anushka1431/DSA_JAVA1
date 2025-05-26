package Recursion;

import java.util.Arrays;

//divide and conquer
//O(nlogn) worst and best case
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={2,0,2,1,1,0};
        arr=mergesort(arr);
        System.out.print(Arrays.toString(arr));
    }
    static int[] mergesort(int[] arr){
        //base condition
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left=mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right=mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    static int[] merge(int[] first, int[] second){
        int[] mix=new int[first.length+second.length];
        int i=0;
        int j=0;
        int k=0;
        //check while combining if first element is bigger or smaller than second and put in mixed array likewise
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        //possible that one array gets finished but the second still has elements left
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
}
