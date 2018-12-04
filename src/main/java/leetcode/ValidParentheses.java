package leetcode;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 有效的括号
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = s.toCharArray();
        try {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                    linkedList.push(chars[i]);
                } else if (chars[i] == ')' && linkedList.pop() != '(') {
                    return false;
                } else if (chars[i] == ']' && linkedList.pop() != '[') {
                    return false;
                } else if (chars[i] == '}' && linkedList.pop() != '{') {
                    return false;
                }
            }
        }catch(NoSuchElementException e){
            return false;
        }
        return linkedList.size() == 0;
    }

    public static void main(String[] args){
        String test = "()";
        isValid(test);
    }
}
