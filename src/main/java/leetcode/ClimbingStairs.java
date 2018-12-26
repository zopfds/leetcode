package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/24
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        long result = 0;
        for(int i = 0 ; i <= n ; i ++){
            if((n - i) % 2 == 0){
                long p = (n - i) / 2 + i;
                long min = Math.min(p - i , i);
                result += Cmn(p , min) / Cmn(min , min);
            }
        }
        return (int)result;
    }

    public long Cmn(long total , long n){
        long result = 1;
        for(int i = 0 ; i < n ; i ++){
            result *= total - i;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new ClimbingStairs().climbStairs(45));
    }
}
