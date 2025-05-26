package Recursion;

public class recursion {
    public static void main(String[] args) {
        //numrec(5);
        //System.out.print(factorial(5));
        //System.out.print(count0(2705008));
        System.out.print(findindex(new int[]{1,3,5,7,2,9,3},7,0));
    }
    static void numrec(int n){
        if(n==0){
            return;
        }

        numrec(n-1);
        System.out.print(n);
    }
    static int factorial(int n ){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
    static int reverse(int n){
        if(n%10==n){
            return n;
        }
        return n%10 ;
    }
    static int count0(int n){
        return helper(n,0);
    }
    static int helper(int n , int count){
        if(n==0){
            return count;
        }
        int rem=n%10;
        if(rem==0){
            return helper(n/10,count+1);

        }
        return helper(n/10,count);
    }
    static int findindex(int[] arr,int target,int index){
        if(index==arr.length){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        else{
            return findindex(arr,target,index+1);
        }
    }


}
