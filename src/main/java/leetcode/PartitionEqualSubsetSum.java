package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/27
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            sum += nums[i];
        }
        if((sum & 1) == 1){
            return false;
        }
        int n = sum / 2;
        boolean[][] result = new boolean[nums.length][n + 1];
        result[0][nums[0]] = true;
        for(int i = 1 ; i < nums.length ; i ++){
            for(int j = 0 ; j < n + 1 ; j ++){
                result[i][j] = result[i - 1][j];
                if(j - nums[i] > 0){
                    result[i][j] = result[i][j] || result[i - 1][j - nums[i]];
                }else if(j - nums[i] == 0){
                    result[i][j] = true;
                }
            }
        }
        return result[nums.length - 1][n];
    }

    public static  void main(String[] args){
        int[] test = {1,2,3,5};
        System.out.println(new PartitionEqualSubsetSum().canPartition(test));
    }
}
