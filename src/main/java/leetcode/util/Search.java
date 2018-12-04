package leetcode.util;

/**
 * 搜索
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class Search {
    public static int binarySearchCloser(int[] nums , int start , int end , int target){
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("null nums");
        }

        if(target <= nums[start]){
            return start;
        }else if(target >= nums[end]){
            return end;
        }else{
            int middle = (start + end) / 2;
            if(nums[middle] == target){
                return middle;
            }else if(nums[middle] < target){
                return binarySearchCloser(nums , start , middle - 1 , target);
            }else{
                return binarySearchCloser(nums , middle + 1 , end , target);
            }
        }
    }
}
