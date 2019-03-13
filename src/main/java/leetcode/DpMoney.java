package leetcode;

/**
 * 动态规划解决找钱问题
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/12
 */
public class DpMoney {

    /**
     * 获取找钱张数最少的方法（货币可重复利用）
     * @param money
     * @param aim
     * @return
     */
    public int getLestMoneyCount(int[] money , int aim){
        if(aim < 0){
            return 0;
        }
        //构造动态规划表
        int[][] result = new int[money.length][aim + 1];
        //初始化第一列，表示兑换0元需要0个硬币
        for(int i = 0 ; i < money.length ; i ++){
            result[i][0] = 0;
        }
        //初始化第一行，表示兑换i元正好要第一种货币的格式
        for(int i = 1 ; i < aim + 1 ; i ++){
            //这一步开始就能提现动规的思想
            if(i - money[0] >= 0 && result[0][i - money[0]] != Integer.MAX_VALUE){
                result[0][i] = result[0][i - money[0]] + 1;
            }else {
                result[0][i] = Integer.MAX_VALUE;
            }
        }
        //动规扫描每一行,从上到下
        for(int i = 1 ; i < money.length ; i ++){
            //动规扫描每一列，从左到右
            for(int j = 1 ; j < aim + 1 ; j ++){
                int value = j - money[i] , thisResult = Integer.MAX_VALUE;
                if(value >= 0 && result[i][value] != Integer.MAX_VALUE){
                    thisResult = result[i][value] + 1;
                }
                result[i][j] = Math.min(thisResult , result[i-1][j]);
            }
        }
        return result[money.length - 1][aim] == Integer.MAX_VALUE ? -1 : result[money.length - 1][aim];
    }

    /**
     * 获取找钱张数最少的方法（货币可重复使用）
     *
     * 优化空间复杂度，从O(n^2)减少到O(n)
     * 优化前提是当前子问题的求解不需要"往上"追溯多级
     * @param money
     * @param aim
     * @return
     */
    public int getLestMoneyCountII(int[] money , int aim){
        if(aim < 0){
            return 0;
        }
        //构造动态规划表
        int[] result = new int[aim + 1];
        //初始化第一列，表示兑换0元需要0个硬币
        result[0] = 0;
        //初始化第一行，表示兑换i元正好要第一种货币的张数
        for(int i = 1 ; i < aim + 1 ; i ++){
            //这一步开始就能提现动规的思想
            if(i - money[0] >= 0 && result[i - money[0]] != Integer.MAX_VALUE){
                result[i] = result[i - money[0]] + 1;
            }else {
                result[i] = Integer.MAX_VALUE;
            }
        }
        //动规扫描一行,从上到下
        for(int i = 1 ; i < money.length ; i ++){
            //动规扫描每一列，从左到右
            for(int j = 1 ; j < aim + 1 ; j ++){
                int value = j - money[i] , thisResult = Integer.MAX_VALUE;
                if(value >= 0 && result[value] != Integer.MAX_VALUE){
                    thisResult = result[value] + 1;
                }
                result[j] = Math.min(thisResult , result[j]);
            }
        }
        return result[aim] == Integer.MAX_VALUE ? -1 : result[aim];
    }

    /**
     * 求换钱方法数最大值(动态规划)
     * @param money
     * @param aim
     * @return
     */
    public int getMaxWay(int[] money , int aim){
        if(aim < 0){
            return 0;
        }

        int[] result = new int[aim + 1];
        result[0] = 0;
        //初始化第一行的数据
        for(int i = 0 ; i < aim + 1 ; i ++){
            if(i % money[0] == 0){
                result[i] = 1;
            }
        }

        /**
         * 动态规划扫描
         */
        for(int i = 1 ; i < money.length ; i ++){
            for(int j = 1 ; j < result.length ; j ++){
                if(j - money[i] >= 0) {
                    result[j] += result[j - money[i]];
                }
            }
        }
        return result[aim];
    }

    public static void main(String[] args){
        System.out.println(new DpMoney().getMaxWay(new int[]{1,5,10,25} , 15));
    }
}
