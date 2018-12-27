package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/27
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0){
            return false;
        }
        return binSearch(nums , target ,0 , nums.length - 1);
    }

    private boolean binSearch(int[] nums , int target , int start , int end){
        while(start < end){
            int middle = (start + end) / 2;
            if(nums[middle] == target || nums[start] == target || nums[end] == target){
                return true;
            }else if(nums[middle] == nums[start] || nums[middle] == nums[end] || nums[start] == nums[end]){
                return binSearch(nums , target , start + 1 , middle - 1) || binSearch(nums , target , middle + 1 , end - 1);
            }else if(nums[middle] > nums[start]){
                if(target < nums[middle]){
                    return binSearch(nums , target , start + 1 , middle - 1) || binSearch(nums , target , middle + 1 , end - 1);
                }else{
                    start = middle + 1;
                }
            }else{
                if(target > nums[middle]){
                    if(target > nums[end]){
                        end = middle - 1;
                    }else{
                        start = middle + 1;
                    }
                }else{
                    end = middle - 1;
                }
            }
        }
        return nums[start] == target;
    }

    public static void main(String[] args){
        int[] test = {-9,-9,-9,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-5,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,-1,0,0,0,1,1,2,2,2,2,2,2,2,3,3,3,3,4,4,4,4,4,5,5,5,5,5,5,5,6,6,6,7,7,7,7,7,8,9,9,9,10,10,10,10,10,10,10,-10,-9,-9,-9,-9};
        System.out.println(new SearchinRotatedSortedArrayII().search(test , 2));
    }
}
