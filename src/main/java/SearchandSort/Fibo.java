package SearchandSort;

public class Fibo {
    public static void main(String[] args) {
        System.out.print(fibonacci(5));
    }
    static int fibonacci(int n){
        if(n<2){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);

    }
}
