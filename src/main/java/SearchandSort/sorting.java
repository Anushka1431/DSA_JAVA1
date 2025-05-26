package SearchandSort;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int[] arr={2,1,4,3,5};
        bubble(arr);
        //cyclic(arr);
        System.out.print(Arrays.toString(arr));

    }
    //compare 1 ans the one before that and swap if 0 is greater than 1 and when it isnt then break and go to the i ie next element
    //best avg worst On On^2 On^2
    static void bubble(int[] arr){
        boolean swapped=false;
        for(int i=1;i<arr.length;i++){
            swapped=false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped=true;
                }
            }
            if(!swapped) {
                break;
            }
        }

    }
    //comparisons n-1,n-2,n-3....(n-1)n/2....which is n^2
    static void selection(int[] arr){//find biggest and put in the end
        for(int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            int max=findmaxinteger(arr,0,last);
            swap(arr,max,last);
        }
    }
    //pick element at 1 and check from right to left if it is greater than value at 0 and swap
    //we have to do this for every element in the j loop till 0 from right to left so everything gets sorted
    //n n^2 n^2
    static void insertion(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }
    //better version O(n)
//    static void insertion(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            int current = arr[i];
//            int j = i - 1;
//            while (j >= 0 && arr[j] > current) {
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = current;
//        }
//    }

    static void cyclic(int[] arr){
        int i=0;
        while(i<arr.length){
            int correctindex=arr[i]-1;
            if(arr[i]!=arr[correctindex]){
                swap(arr,i,correctindex);
            }
            else{
                i++;
            }
        }
    }
    static void swap(int[] arr, int first,int second){
        int temp=arr[second];
        arr[second]=arr[first];
        arr[first]=temp;
    }

    static int findmaxinteger(int[] arr,int start,int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
}
