package leetcode;

import java.util.ArrayList;

/**
 * 栈
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/19
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0 , j = 0 , top = -1;
        int[] stack = new int[pushed.length];
        if(pushed.length == 0){
            return popped.length == 0;
        }
        stack[++top] = pushed[i++];
        while(top != -1 || j < popped.length){
            if(top != -1 && stack[top] == popped[j]){
                top--;
                j++;
            }else{
                if(i < pushed.length){
                    stack[++top] = pushed[i++];
                }else{
                    return false;
                }
            }
        }
        return top == -1;
    }

    public static void main(String[] args){
        int[] push = {4,0,1,2,3} , poped = {4,2,3,0,1};
        System.out.println(new ValidateStackSequences().validateStackSequences(push , poped));
    }
}
