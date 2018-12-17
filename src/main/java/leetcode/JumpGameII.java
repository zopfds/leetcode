package leetcode;

import java.util.*;

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

        int reach = 0 , nextReach = nums[0];
        int count = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            nextReach = Math.max(nextReach , i + nums[i]);
            if(nextReach >= nums.length - 1){
                return count + 1;
            }
            if(i == reach){
                count++;
                reach = nextReach;
            }
        }
        return count;
    }


//    public static int jump(int[] nums) {
//        if(nums.length < 2){
//            return 0;
//        }
//        if(nums.length == 2){
//            return 1;
//        }
//
//        LinkedList<Integer> stepList = new LinkedList<>();
//        LinkedList<Integer> timeList = new LinkedList<>();
//        stepList.offerFirst(0);
//        timeList.offerFirst(0);
//        Integer step = 0;
//        Integer time = 0;
//
//        while(stepList.size() > 0) {
//            step = stepList.pollLast();
//            time = timeList.pollLast();
//            if(step >= nums.length -1){
//                return time;
//            }
//            if(step + nums[step] >= nums.length - 1){
//                return time + 1;
//            }
//            for(int i = 1 ; i <= nums[step] ; i ++){
//                if(step + i + 1 < nums[step] && nums[step + i] <= nums[step + i + 1] - 1){
//                    continue;
//                }
//                stepList.offerFirst(step + i);
//                timeList.offerFirst(time + 1);
//            }
//        }
//
//        return time + 1;
//    }

//    public static int jumpNext(int[] nums , int step , int start){
//        if(start >= nums.length - 1){
//            return step;
//        }
//
//        if(nums[start] + start >= nums.length - 1){
//            return step + 1;
//        }
//
//        int min = nums.length;
//        for(int j = 1 ; j <= nums[start] ; j ++ ){
//            if(start + j + 1 < nums[start] && nums[start + j] <= nums[start + j + 1] + 1){
//                continue;
//            }
//            int thisMinStep = jumpNext(nums , step + 1 , start + j);
//            if(thisMinStep < min){
//                min = thisMinStep;
//            }
//        }
//        return min;
//    }

    public static void main(String[] args){
        int[] test = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(jump(test));
    }
}
