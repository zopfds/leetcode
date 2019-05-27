package leetcode;


/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/16
 */
public class _132Pattern {
    public boolean find132pattern(int[] nums) {
        int[] stack = new int[nums.length];
        int top = -1;
        int[] rightBig = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i ++){
            while(top != -1 && nums[stack[top]] > nums[i]){
                rightBig[stack[top--]] = i;
            }
            stack[++top] = i;
        }
        while(top > -1){
            rightBig[stack[top--]] = -1;
        }
        for(int i = 0 ; i < nums.length ; i ++){
            while(top != -1 && nums[stack[top]] > nums[i]){
                top--;
            }
            stack[++top] = i;
            if(top >= 1
                    && rightBig[stack[top]] > i
                    && nums[stack[top - 1]] < nums[rightBig[stack[top]]]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] test = {1,2,3,4};
        System.out.println(new _132Pattern().find132pattern(test));
    }
}
