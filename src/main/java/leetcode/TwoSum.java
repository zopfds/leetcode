package leetcode;

import leetcode.util.Println;
import leetcode.util.Sort;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int a = nums.length;

        for(int i = 0 ; i < a ; i ++){
            for(int j = i + 1; j < a ; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {

        int a = nums.length;

        for(int i = 0 ; i < a ; i ++){
            for(int j = i + 1; j < a ; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();

        int[] test = {3,2,4};

        Println.printlnArray(twoSum.twoSum(test , 6));
    }
}
