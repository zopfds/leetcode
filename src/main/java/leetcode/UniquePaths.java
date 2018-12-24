package leetcode;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        int min = m + n - 2 - Math.max(m - 1 , n - 1);
        return (int) (jie(m + n - 2 , min) / jie(min , min));
    }

    public static long jie(int a , int b){
        long result = 1;
        for(; b > 0 ; b --){
            result = result * (a--);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(10,10));
    }
}
