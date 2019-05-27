package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/26
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if(target == 0 || nums.length == 0){
            return 0;
        }

        int[][] result = new int[nums.length][target + 1];
        for(int i = 0 ; i < result.length ; i ++){
            for(int j = 1 ; j < target + 1; j ++){
                if(j - nums[i] == 0){
                    result[i][j] = 1;
                    if(i != 0){
                        result[i][j] += result[i - 1][j];
                    }
                }else if(j - nums[i] > 0){
                    result[i][j] = result[i][j - nums[i]];
                    if(i != 0){
                        result[i][j] += result[i - 1][j];
                    }
                }else{
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[nums.length - 1][target];
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        System.out.println(new CombinationSumIV().combinationSum4(nums , 4));
    }
}
