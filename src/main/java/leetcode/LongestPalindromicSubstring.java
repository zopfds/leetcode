package leetcode;


/**
 * 动态规划，最主要的是列出状态转移方程
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/12
 */
public class LongestPalindromicSubstring {

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }

        boolean[][] result = new boolean[s.length()][s.length()];
        int min = 0 , max = 0 , maxLength = 1;
        for(int i = 0 ; i < s.length() ; i ++){
            result[i][i] = true;
        }
        for(int i = 1 ; i < s.length(); i ++){
            if(s.charAt(i - 1) == s.charAt(i)){
                result[i - 1][i] = true;
                if(2 > maxLength){
                    min = i - 1;
                    max = i;
                    maxLength = 2;
                }
            }else{
                result[i - 1][i] = false;
            }
        }
        //先计算一个回文子串,
        for(int i = 2 ; i < result.length ; i++){
            for(int j = i ; j < result.length ; j ++){
                if(result[j - i + 1][j - 1] == true && s.charAt(j - i) == s.charAt(j)){
                    if(i + 1> maxLength){
                        maxLength = i;
                        min = j - i;
                        max = j;
                    }
                    result[j - i][j] = true;
                }
            }
        }
        return s.substring(min , max + 1);
    }

    public static void main(String[] args){
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babab"));
    }
}
