package leetcode;

import java.util.Arrays;

/**
 * 求出三数和最近的结果
 *
 * startTime:   2018-12-03 13:49
 * endTime:     2018-12-03
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class ThreeSumClosest {
    /**
     * 三数求和求最近
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3){
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums , 0 , nums.length);
        int result = nums[0] + nums[1] + nums[2];
        int dis = absolu(result - target);
        if(target <= result){
            return result;
        }
        //比最大的三个数都大直接返回
        int max = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        if(max <= target){
            return max;
        }
        for(int i = 0 ; i < nums.length - 2 ; i++){
            int j = i + 1 , k = nums.length - 1;
            //比本次循环最小的三个数都小，跟result比较并且跳过本次循环
            int thisMin = nums[i] + nums[j] + nums[j + 1];
            if(target < thisMin){
                int minDis = absolu(thisMin - target);
                if(minDis < dis){
                    result = thisMin;
                    dis = minDis;
                }
                continue;
            }else if(target == thisMin){
                return target;
            }
            //比本次循环最大的三个数都大，跟result比较并且跳过本次循环
            int thisMax = nums[i] + nums[nums.length - 1] + nums[nums.length - 2];
            if(target >= thisMax){
                int maxDis = absolu(thisMax - target);
                if(maxDis < dis){
                    result = thisMax;
                    dis = maxDis;
                }
                continue;
            }else if(target == thisMax){
                return target;
            }
            while(j < k) {
                int thisNum = nums[i] + nums[j] + nums[k];
                int thisDis = absolu(thisNum - target);
                if(thisNum < target){
                    if(thisDis < dis){
                        result = thisNum;
                        dis = thisDis;
                    }
                    j++;
                }else if(thisNum > target){
                    if(thisDis < dis){
                        result = thisNum;
                        dis = thisDis;
                    }
                    k--;
                }else{
                    return thisNum;
                }
            }
        }
        return result;
    }

    public static int absolu(int value){
        return value < 0 ? -value:value;
    }

    public static void main(String[] args){
        int[] test = new int[]{1,1,1,1};
        System.out.println(threeSumClosest(test , 0));
    }
}
