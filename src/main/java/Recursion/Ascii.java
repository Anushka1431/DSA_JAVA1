package Recursion;

public class Ascii {
    public static void main(String[] args) {
        //char ch='a';
        //System.out.println(ch);
        subseqASCII("","abc");
    }
    //subseq permuations along with the ASCII value
    static void subseqASCII(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return ;
        }
        char ch=up.charAt(0);
        subseqASCII(p+ch,up.substring(1));
        subseqASCII(p,up.substring(1));
        subseqASCII(p+(ch+0),up.substring(1));
    }
}
