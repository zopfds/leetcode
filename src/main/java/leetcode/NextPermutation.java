package leetcode;

import leetcode.util.Println;

/**
 * 下一个排列
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/7
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }

        //先找出第一个nums[i] < nums[i + 1]的元素
        int i = nums.length - 2;
        for(; i >= 0 ; i--){
            if(nums[i] < nums[i + 1]){
                break;
            }
        }

        int j = i + 1,k = 0;
        //如果i在数组中存在，则进行下列判断
        if(i != -1) {
            //从i+1开始寻找比nums[i]大的数中最小的一个，令其下标为j
            int biggerThani = nums[j];
            for (int m = nums.length - 1 ; m > j; m--) {
                if (nums[m] > nums[i] && nums[m] <= biggerThani) {
                    biggerThani = nums[m];
                    j = m;
                    break;
                }
            }

            //交换nums[i]和nums[j]
            k = nums[i];
            nums[i] = nums[j];
            nums[j] = k;
        }

        //从j开始到数组末尾对称交换
        for(int l = 0 ; l < (nums.length - (i + 1)) / 2 ; l ++){
            k = nums[l + (i + 1)];
            nums[l + (i + 1)] = nums[nums.length - 1 - l];
            nums[nums.length - 1 - l] = k;
        }

        return;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,3,3};
        nextPermutation(nums);
        Println.printArray(nums);
    }
}
