package leetcode;

import java.util.stream.IntStream;

/**
 * 背包问题
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/13
 */
public class PackageProblem {

    /**
     * 不限制数量背包
     * @param v
     * @param w
     * @param V
     * @return
     */
    private int CountPackage(int[] v , int[] w , int V){
        if(v == null || v.length == 0 || w == null || w.length == 0 || V == 0){
            return 0;
        }

        int[][] wArrays = new int[v.length][V + 1];
        //初始化第一行
        IntStream.range(1 , V + 1).forEach(a -> {
            if(a - v[0] >= 0){
                wArrays[0][a] = wArrays[0][a - v[0]] + w[0];
            }
        });
        IntStream.range(1 , v.length).forEach(a -> {
            IntStream.range(1 , V + 1).forEach(b ->{
                int weight = 0;
                if(b - v[a] >= 0){
                    weight = wArrays[a][b - v[a]] + w[a];
                }
                wArrays[a][b] = Math.max(weight , wArrays[a - 1][b]);
            });
        });
        return wArrays[v.length - 1][V];
    }

    /**
     * 不限制数量背包
     *
     * 优化数组，只需要一维动态数组，空间复杂度优化
     * @param v
     * @param w
     * @param V
     * @return
     */
    private int CountPackageII(int[] v , int[] w , int V){
        if(v == null || v.length == 0 || w == null || w.length == 0 || V == 0){
            return 0;
        }

        int[] wArrays = new int[V + 1];
        //初始化第一行
        IntStream.range(1 , V + 1).forEach(a -> {
            if(a - v[0] >= 0){
                wArrays[a] = wArrays[a - v[0]] + w[0];
            }
        });
        IntStream.range(1 , v.length).forEach(a -> {
            IntStream.range(1 , V + 1).forEach(b ->{
                int weight = 0;
                if(b - v[a] >= 0){
                    weight = wArrays[b - v[a]] + w[a];
                }
                wArrays[b] = Math.max(weight , wArrays[b]);
            });
        });
        return wArrays[V];
    }

    /**
     * 限制数量的背包问题，n重背包
     * @param v
     * @param w
     * @param c
     * @param V
     * @return
     */
    private int limitPackage(int[] v , int[] w , int[] c , int V){
        if(v == null || v.length == 0 ||
                w == null || w.length == 0 ||
                c == null || c.length == 0 ||
                V == 0){
            return 0;
        }

        int[][] wArrays = new int[v.length][V + 1];
        int[][] countArrays = new int[v.length][V + 1];
        //初始化第一行数据
        IntStream.range(0 , V + 1).forEach(a ->{
            if(a - v[0] >= 0 && a / v[0] <= c[0]){
                wArrays[0][a] = wArrays[0][a - v[0]] + w[0];
            }
        });
        //
        IntStream.range(1 , v.length).forEach(a ->{
            IntStream.range(1 , V + 1).forEach(b ->{
                int weight = 0 , count = 0;
                //获取前一个最大值的数量 而且 前一个的最大价值的a物品的数量必须要小于最大值
                if(b - v[a] >= 0 && countArrays[a][b - v[a]] < c[a]){
                    weight = wArrays[a][b - v[a]] + w[a];
                    if(weight > wArrays[a - 1][b]){
                        count  = wArrays[a][b - v[a]] + 1;
                    }
                }
                countArrays[a][b] = count;
                wArrays[a][b] = Math.max(weight , wArrays[a -1][b]);
            });
        });
        return wArrays[v.length - 1][V];
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        int[] v = new int[]{12, 3 , 10 , 3 , 6};
        int[] w = new int[]{5 , 4 , 7, 2, 6};
        int[] c = new int[]{2 , 4 , 1, 5, 3};
        System.out.println(new PackageProblem().limitPackage(v , w , c ,  15));
    }
}
