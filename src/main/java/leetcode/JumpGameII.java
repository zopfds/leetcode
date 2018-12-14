package leetcode;

/**
 * 跳跃游戏
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/13
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        if(nums.length == 2){
            return 1;
        }

        return jumpNext(nums , 0 , 0);
    }

    public static int jumpNext(int[] nums , int step , int start){
        if(start >= nums.length - 1){
            return step;
        }

        if(nums[start] + start >= nums.length - 1){
            return step + 1;
        }

        int min = Integer.MAX_VALUE;
        for(int j = 1 ; j <= nums[start] ; j ++ ){
            int thisMinStep = jumpNext(nums , step + 1 , start + j);
            if(thisMinStep < min){
                min = thisMinStep;
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] test = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        System.out.println(jump(test));
    }
}
