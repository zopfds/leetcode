package leetcode;

import leetcode.util.Println;

public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }else if(nums.length == 1){
            return nums[0] == target ? new int[]{0 , 0} : new int[]{-1 , -1};
        }else if(nums[0] == target && nums[nums.length - 1] == target){
            return new int[]{0 , nums.length - 1};
        }

        int i = 0 , j = nums.length -1;
        int start = 0 , end = nums.length - 1;
        int middle = (i + j) / 2;
        while(nums[middle] != target && i < j){
            if(nums[middle] < target){
                i = middle + 1;
            }else if(nums[middle] > target){
                j = middle - 1;
            }
            middle = (i + j) / 2;
        }

        if(nums[middle] == target){
            if(nums[i] != target){
                start = searchFromLeft(nums , i , middle , target);
            }else{
                start = i;
            }
            if(nums[j] != target){
                end = searchFromRight(nums, middle, j , target);
            }else{
                end = j;
            }
            return new int[]{start , end};
        }

        return new int[]{-1,-1};
    }

    public static int searchFromLeft(int[] nums , int start , int end , int target){
        while(start < end){
            if(start == end - 1){
                return nums[start] == target ? start : end;
            }
            int middle = (start + end) / 2;
            if(nums[middle] == target){
                end = middle;
            }else{
                start = middle + 1;
            }
        }
        return end;
    }

    public static int searchFromRight(int[] nums , int start , int end , int target){
        while(start < end){
            if(start == end - 1){
                return nums[end] == target ? end : start;
            }
            int middle = (start + end) / 2;
            if(nums[middle] == target){
                start = middle;
            }else{
                end = middle - 1;
            }
        }
        return start;
    }
    public static void main(String[] args){
        int[] test = {0,0,1,1,2,3};
        Println.printArray(searchRange(test , 0));
    }
}
