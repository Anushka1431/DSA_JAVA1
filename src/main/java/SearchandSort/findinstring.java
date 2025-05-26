package SearchandSort;

public class findinstring {
    public static void main(String[] args) {
        String s="Anushka";
        char find='a';
        boolean ans=lsearch1(s,find);
        System.out.print(ans);
        System.out.print(s.toCharArray());
    }

    static boolean lsearch1(String str, char target){
        if(str.isEmpty()){
            return false;
        }
        for(char ch:str.toCharArray()){
            if(ch==target)
                return true;


        }
        return false;
    }
}
