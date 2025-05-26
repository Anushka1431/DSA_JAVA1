package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr={1,2,2};
        System.out.print(subsetwithduplicates(arr));
    }
    //to iteratively make all possible combinations of 1,2,3 take an outer list and an inner list
    //the other list is the total list and then that  goes one step down after adding an element and then u create
    //an inner list by adding another element into the earlier outer list
    //thi creates the new outer list
    //this is many lists inside another list
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num: arr){
            int n=outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner=new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
    //whenever theres duplicates, while adding the new duplicate number into the lists only add them in the internal list and not the full outer one
    static List<List<Integer>> subsetwithduplicates(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();

        outer.add(new ArrayList<>());
        int start=0;
        int end=0;

        for(int i=0;i<arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }

            int n=outer.size();
            end=n-1;

            for (int j = start; j < n; j++) {
                List<Integer> inner=new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        return outer;
    }

}
