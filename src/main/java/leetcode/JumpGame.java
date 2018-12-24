package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/18
 */
public class JumpGame {
    public static boolean canJump(int[] nums) {
        return canJ(nums , 0);
    }

    public static boolean canJ(int[] nums , int start){
        if(start >= nums.length - 1){
            return true;
        }
        if(start + nums[start] >= nums.length - 1 ){
            return true;
        }

        for(int i = 1 ; i <= nums[start] ; i ++){
            if(canJ(nums , start + i)){
                return true;
            }
        }

        return false;
    }

    public static boolean canJump1(int[] nums) {
        int reach = 0 , max = 0;
        for(int start = reach ; start < nums.length ; start++){
            if(start > reach){
                if(nums[start - 1] == 0 && max == reach){
                    return false;
                }
                reach = max;
            }
            max = Math.max(start + nums[start] , max);
        }
        return true;
    }

    public static void main(String[] args){
        int[] test = {1,0,2};
        System.out.println(canJump1(test));
    }
}
