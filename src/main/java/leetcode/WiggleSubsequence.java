package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/25
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int[] result = new int[nums.length];
        int start = 1;
        while(nums[start - 1] == nums[start] && start < nums.length){
            start ++;
        }
        if(start == nums.length){
            return 0;
        }else if(start == nums.length - 1){
            return 2;
        }
        result[start] = 2;
        boolean asc = nums[start] > nums[start - 1] ? false : true;
        start ++;
        for(; start < nums.length ; start ++){
            if(nums[start] > nums[start - 1]){
                if(asc){
                    result[start] = result[start - 1] + 1;
                    asc = !asc;
                }else{
                    result[start] = result[start - 1];
                }
            }else if(nums[start] < nums[start - 1]){
                if(asc){
                    result[start] = result[start - 1];
                }else{
                    result[start] = result[start - 1] + 1;
                    asc = !asc;
                }
            }else{
                result[start] = result[start - 1];
            }
        }
        return result[nums.length - 1];
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,7,4,9,2,5};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }
}
