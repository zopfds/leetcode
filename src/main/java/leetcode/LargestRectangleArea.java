package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/18
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] height){
        int ret = 0;
        int[] stack = new int[height.length];
        int top = -1;
        for(int i = 0 ; i < height.length ; i ++){
            while(top != -1 && height[stack[top]] >= height[i]){
                int h = height[stack[top]];
                top--;
                int side = top > -1 ? stack[top] : -1;
                ret = Math.max(ret , h * (i - side - 1));
            }
            stack[++top] = i;
        }
        return ret;
    }

    public static void main(String[] args){
        int[] test = {1,3,2,0};
        System.out.println(new LargestRectangleArea().largestRectangleArea(test));
    }
}
