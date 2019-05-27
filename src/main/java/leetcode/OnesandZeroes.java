package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/29
 */
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] count = new int[strs.length][2];
        for(int i = 0 ; i < strs.length ; i ++){
            int zeroCount = 0 , oneCount = 0;
            for(int j = 0 ; j < strs[i].length() ; j ++){
                if(strs[i].charAt(j) == '0'){
                    zeroCount ++;
                }else{
                    oneCount ++;
                }
            }
            count[i][0] = zeroCount;
            count[i][1] = oneCount;
        }
        int[][][] result = new int[strs.length][m + 1][n + 1];
        for(int i = 0 ; i < strs.length ; i ++){
            for(int j = 0 ; j < m + 1 ; j ++){
                for(int k = 0 ; k < n + 1 ; k ++){
                    if(i == 0){
                        if(j >= count[i][0] && k >= count[i][1]){
                            result[i][j][k] = 1;
                        }
                    }else{
                        result[i][j][k] = result[i - 1][j][k];
                        if((j - count[i][0] >= 0) && (k - count[i][1]) >= 0){
                            result[i][j][k] = Math.max(result[i][j][k] , result[i - 1][j - count[i][0]][k - count[i][1]] + 1);
                        }
                    }
                }
            }
        }
        return result[strs.length - 1][m][n];
    }

    public static void main(String[] args){
        String[] strs = {"10","0","1"};
        System.out.println(new OnesandZeroes().findMaxForm(strs , 1 , 1));
    }
}
