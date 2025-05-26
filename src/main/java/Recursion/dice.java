package Recursion;

import java.util.ArrayList;

public class dice {
    public static void main(String[] args) {
       // dicesum("",4);
        System.out.println(dicesum2("",4));
        System.out.println(dicesumcount("",4));
    }
    static void dicesum(String p, int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=6 && i<=target;i++){
            dicesum(p+i,target-i);
        }
    }
    static ArrayList<String> dicesum2(String p, int target){
        if(target==0){
            ArrayList<String> arr= new ArrayList<>();
            arr.add(p);
            return arr;
        }
        ArrayList<String> ans= new ArrayList<>();

        for(int i=1;i<=6 && i<=target;i++){
            ans.addAll(dicesum2(p+i,target-i));
        }
        return ans;
    }
    static int dicesumcount(String p, int target){
        if(target==0){
            return 1;
        }
        int count=0;

        for(int i=1;i<=6 && i<=target;i++){
            count=count+dicesumcount(p+i,target-i);
        }
        return count;
    }

}
