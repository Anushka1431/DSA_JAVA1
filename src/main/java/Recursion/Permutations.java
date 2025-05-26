package Recursion;

public class Permutations {
    public static void main(String[] args) {
        permutations("","abc");
    }
    //create permutations for abc like bca acb bac like that

    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);

//make 2 strings and put ch in between
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            permutations(f+ch+s,up.substring(1));
        }
    }
}
