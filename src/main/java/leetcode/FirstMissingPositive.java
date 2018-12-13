package leetcode;

/**
 * 第一个缺失的正数
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/13
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE,count = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] > 0){
                count++;
                if(nums[i] < min){
                    min = nums[i];
                }
            }
        }

        if(min > 1){
            return 1;
        }

        int[] win = new int[count];
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] <= count && nums[i] > 0){
                win[nums[i] - min] = 1;
            }
        }
        for(int i = 0 ; i < count ; i ++){
            if(win[i] != 1){
                return min + i;
            }
        }
        return count + 1;
    }

    public static void main(String[] args){
        int[] test = {1,2,0};
        System.out.println(firstMissingPositive(test));
    }
}
