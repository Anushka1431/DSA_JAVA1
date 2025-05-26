package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int target=4;
        int ans=LinearSearch(nums,target);
        System.out.print(ans);
    }

    static int LinearSearch(int arr[], int target) {
        if (arr.length == 0) {
            return -1;
        }
        for(int i=0;i<arr.length;i++){
            int element=arr[i];
            if(element==target){
                return i;
            }
        }
        return 0;
    }}

