package Recursion;

import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
        //System.out.println(skip("ghabsaasda"));
        //System.out.println(skipapple("ghabappleda"));

        //System.out.println(findpermutations("","abc"));

    }
    //write a program to skip a's in a string
     static String skip(String up){
        //basecase
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            return skip(up.substring(1));
        }
        else{
            return ch+skip(up.substring(1));
        }
    }
    static String skipapple(String up){
        //basecase
        if(up.isEmpty()){
            return "";
        }

        if(up.startsWith("apple")){
            return skipapple(up.substring(5));
        }
        else{
            return up.charAt(0)+skipapple(up.substring(1));
        }
    }

    //permutations subseq abc . this should give us all the substrings like a,b,c,ab,ac,bc. string processed and unprocessed are 2 parameters takenn
    static ArrayList<String> findpermutations(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch= up.charAt(0);
        ArrayList<String> left= findpermutations(p+ch,up.substring(1));
        ArrayList<String> right= findpermutations(p,up.substring(1));
        left.addAll(right);
        return left;
    }
}
