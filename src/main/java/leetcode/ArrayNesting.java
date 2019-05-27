package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/26
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int maxCount = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] >= 0){
                int first = nums[i],second = Math.abs(nums[nums[i]]),thisCount = 1;
                if(nums[nums[i]] > 0){
                    nums[nums[i]] = - nums[nums[i]];
                }
                nums[i] = -nums[i];
                while(Math.abs(first) != Math.abs(second)){
                    first = Math.abs(nums[first]);
                    second = Math.abs(nums[Math.abs(nums[second])]);
                    if(nums[first] > 0){
                        nums[first] = -nums[first];
                    }
                    if(nums[Math.abs(nums[second])] > 0){
                        nums[Math.abs(nums[second])] = -nums[Math.abs(nums[second])];
                    }
                    thisCount++;
                }
                maxCount = Math.max(maxCount , thisCount);
            }
        }
        return maxCount;
    }
}
