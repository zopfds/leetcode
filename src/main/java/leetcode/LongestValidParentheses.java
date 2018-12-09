package leetcode;

import java.util.LinkedList;

/**
 * 匹配最长
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/7
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        int thisMax = 0;
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(i != s.length() - 1 && c == '('){
                stack.offerFirst(i);
            }else{
                Integer posi = stack.pollFirst();
                if(posi == null){
                    result = thisMax > result ? thisMax : result;
                    thisMax = 0;
                }else{
                    if(i == s.length() - 1){
                        if(stack.peekFirst() == null){
                            thisMax += 2;
                        }else{
                            
                        }
                    }
                    thisMax += 2;
                }
            }
        }
        return thisMax > result ? thisMax : result;
    }

    public static void main(String[] args){
        String test = "()(()(()";
        System.out.println(longestValidParentheses(test));
    }
}
