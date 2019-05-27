package leetcode;

import leetcode.util.Println;


/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/18
 */
public class MonotoneStack {
    public int[] getFirstLarger(int[] stack){
        int[] result = new int[stack.length];
        int[] monotoneStack = new int[stack.length];
        int top = -1;
        monotoneStack[++top] = 0;
        result[0] = -1;
        for(int i = 1 ; i < stack.length ; i ++){
            //定位到对应的元素
            while(top != -1 && stack[monotoneStack[top]] < stack[i]) {
                result[monotoneStack[top]] = i - monotoneStack[top];
                top--;
            }
            monotoneStack[++top] = i;
        }
        result[stack.length - 1] = -1;
        return result;
    }

    public static void main(String[] args){
        int[] test = {5,3,1,2,4};
        Println.printArray(new MonotoneStack().getFirstLarger(test));
    }
}
