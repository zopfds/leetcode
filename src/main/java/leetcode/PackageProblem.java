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
                if(b - w[a] >= 0){
                    weight = wArrays[a][b - w[a]] + w[a];
                }
                wArrays[a][b] = Math.max(weight , wArrays[a - 1][b]);
            });
        });
        return wArrays[v.length - 1][V];
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        int[] v = new int[]{12 , 10 , 6, 3, 3};
        int[] w = new int[]{5, 7 , 6 , 4 , 2};
        System.out.println(new PackageProblem().CountPackage(v , w , 15));
    }
}
