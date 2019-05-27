package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/22
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int lineN = (int) Math.sqrt(n);
        int[][] result = new int[lineN][n];
        for(int i = 0 ; i < n ; i++){
            result[0][i] = i + 1;
        }
        for(int i = 1 ; i < lineN ; i++){
            for(int j = 0 ; j < n ; j++){
                int index = (j + 1) - (i + 1) * (i + 1);
                if(index < 0){
                    result[i][j] = result[i - 1][j];
                }else if(index == 0){
                    result[i][j] = 1;
                }else{
                    result[i][j] = Math.min(result[i - 1][j] , result[i][index] + 1);
                }
            }
        }
        return result[lineN - 1][n - 1];
    }

    public static void main(String[] args){
        System.out.println(new PerfectSquares().numSquares(12));
    }
}
