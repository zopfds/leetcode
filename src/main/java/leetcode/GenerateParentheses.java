package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归创建左右括号
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n , "(" , 1 , 0 , result);
        return result;
    }

    public void generate(int n , String s , int left , int right , List<String> result){
        if(left == n && right == n){
            result.add(s);
        }else if(left == right){
            generate(n , s + '(', left + 1 , right , result);
        }else if(left > right && left < n){
            generate(n , s + '(' , left + 1 , right , result);
            generate(n , s + ')' , left , right + 1 , result);
        }else if(left > right && left == n){
            generate(n , s + ')' , left , right + 1 , result);
        }else{
            return;
        }
    }
}
