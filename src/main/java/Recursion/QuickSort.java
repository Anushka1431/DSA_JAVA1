package Recursion;

import java.util.Arrays;
//wworst case when array s already sorted which is 0n^2 because if first is pivot then check rest n-1 then check next n-2 like that hence n^2
//avg case is O(nlogn) recursive tree method if it divides in 2 halves the O(nlogn)
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sort(arr, 0, arr.length - 1);
       System.out.println(Arrays.toString(arr));
        //Arrays.sort(arr);
    }

    static void sort(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {

            // also a reason why if its already sorted it will not swap
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(nums, low, e);
        sort(nums, s, hi);
    }
}