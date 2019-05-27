package leetcode;

/**
 * 拆分整数
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/25
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n == 1){
            return 0;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 1;
        for(int i = 3 ; i < n + 1 ; i++){
            int max = 0;
            for(int j = 1 ; j < i ; j++){
                max = Math.max(Math.max(Math.max(j * result[i - j] , result[j] * (i - j)) , Math.max(result[j] * result[i - j] , j * (i - j))) , max);
            }
            result[i] = max;
        }
        return result[n];
    }

    public static void main(String[] args){
        System.out.println(new IntegerBreak().integerBreak(10));
    }
}
