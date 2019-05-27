package leetcode;

import java.util.Arrays;

/**
 * 剪切钢条
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/25
 */
public class CutBoard {
    /**
     * 递归解决剪切钢条最大价值的问题
     * @param prof
     * @param n
     * @return
     */
    public int cutBoard(int prof[] , int n){
        if(n == 0){
            return 0;
        }

        int max = 0;
        //子问题归纳，如果思考从n , n - 1来递归思考则会将问题复杂化，除了考虑最大价值还需要考虑当前长度能否切割为对应的子问题的长度
        //从已有的盈利集合考虑，将子问题分解为求解  n - prof[0] , n - prof[1] ...... n - prof[prof.length - 1]
        //从而不需要考虑子问题长度的合法性
        for(int i = 1 ; i < prof.length ; i ++){
            if(prof[i] != -1 && n - i >= 0) {
                max = Math.max(max, cutBoard(prof, n - i) + prof[i]);
            }
        }
        return max;
    }

    /**
     * 动态规划解决钢条价值最大的问题(自顶向下)
     * @return
     */
    public int dpCutBoard(int prof[] , int[] dp , int n){
        if(n == 0){
            return 0;
        }
        if(dp[n] > 0){
            return dp[n];
        }

        int max = -1;
        for(int i = 1 ; i < prof.length ; i ++){
            if(prof[i] != -1 && n - i >= 0){
                max = Math.max(max , dpCutBoard(prof , dp , n - i) + prof[i]);
            }
        }
        dp[n] = max;
        return max;
    }

    /**
     * 切割钢管自底向上
     * @param prof
     * @param n
     * @return
     */
    public int dpCutBoardFromBottom(int prof[] , int n){
        int[] result = new int[n + 1];
        Arrays.fill(result , -1);
        result[1] = prof[1];
        result[0] = 0;
        for(int i = 2 ; i < n + 1 ; i ++){
            int max = i < prof.length ? prof[i] : result[i];
            for(int j = 1 ; j <= i / 2 ; j++){
                if(result[j] != -1 && result[i - j] != -1) {
                    max = Math.max(max, result[j] + result[i - j]);
                }
            }
            result[i] = max;
        }
        return result[n];
    }

    int bottomUpCutRodTwo(int pro[], int r[], int n)
    {
        for (int i = 1; i <= n; i++)
        {
            int profit = i < pro.length ? pro[i] : r[i];
            for (int j = 1; j <= i / 2; j++)
                profit = Math.max(profit, r[j] + r[i - j]);
            r[i] = profit;
        }
        return r[n];
    }

    public static void main(String[] args){
        int[] prof = new int[]{0 , 1,  -1 , 4 ,  -1 , 6};
        int[] hasP = new int[11];
        System.out.println(new CutBoard().bottomUpCutRodTwo(prof,hasP, 10));
    }
}
