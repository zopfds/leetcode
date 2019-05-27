package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/25
 */
public class LongestComString {

    /**
     * 最长公共子串(子串为必须连续的串)
     *
     * 状态转移方程:
     *
     * if(a.charAt(i) == b.charAt(j)){
     *     p[i][j] = p[i - 1][j - 1] + 1
     * }else{
     *     p[i][j] = 0;
     * }
     *
     * @return
     */
    public int longestComString(String a , String b){
        int[][] p = new int[a.length()][b.length()];
        int max = 0;
        for(int i = 0 ;i < a.length() ; i ++){
            for(int j = 0 ; j < b.length() ; j ++){
                if(a.charAt(i) == b.charAt(j)){
                    p[i][j] = i == 0 || j == 0 ? 1 : p[i - 1][j - 1] + 1;
                    max = Math.max(max , p[i][j]);
                }
            }
        }
        return max;
    }

    /**
     * 最长公共子序列(子序列可不连续)
     *
     * 状态转移方程
     * if(s.charAt(i) == s.charAt(j)){
     *     p[i][j] = p[i-1][j-1] + 1;
     * }else{
     *     p[i][j] = Math.max(p[i-1][j] , p[i][j-1]);
     * }
     *
     * @return
     */
    public int longestComOrder(String a , String b){
        int[][] p = new int[a.length()][b.length()];
        for(int i = 0 ; i < a.length() ; i ++){
            for(int j = 0 ; j < b.length() ; j ++){
                if(i == 0){
                    p[i][j] = a.charAt(i) == b.charAt(j) ? 1 : p[i][j - 1 >= 0 ? j - 1 : 0];
                }else if(j == 0){
                    p[i][j] = a.charAt(i) == b.charAt(j) ? 1 : p[i - 1 >= 0 ? i - 1 : 0][j];
                }else{
                    if(a.charAt(i) == b.charAt(j)){
                        p[i][j] = p[i - 1][j - 1] + 1;
                    }else{
                        p[i][j] = Math.max(p[i-1][j] , p[i][j-1]);
                    }
                }
            }
        }
        return p[a.length() - 1][b.length() - 1];
    }

    public static void main(String[] args){
        System.out.println(new LongestComString().longestComOrder("abcabde" , "acbe"));
    }
}
