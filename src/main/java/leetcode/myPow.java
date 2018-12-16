package leetcode;

public class myPow {
    public static double myPow(double x, int n) {
        if(n == 0 || x == 1){
            return 1;
        }

        if(x == 0){
            return 0;
        }

        return n > 0 ? pow(x,n) : 1/pow(x , n);
    }

    private static double pow(double x , int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }

        double result = pow(x , n / 2);
        return result * ((n & 1) == 0 ? result : result * x);
    }

    public static void main(String[] args){
        double testD = 2.00000;
        int testN = 10;
        System.out.println(myPow(testD , testN));
    }
}
