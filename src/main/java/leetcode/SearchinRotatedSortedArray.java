package leetcode;

public class SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int i = 0 , j = nums.length - 1;
        while(i < j){
            int middle = (i + j) / 2;
            if(nums[i] == target){
                return i;
            }else if(nums[j] == target){
                return j;
            }else if(nums[middle] == target){
                return middle;
            }else{
                if(nums[middle] < nums[i] && nums[middle] < nums[j]){
                    if(target > nums[i] || target < nums[middle]){
                        j = middle - 1;
                    }else{
                        i = middle + 1;
                    }
                }else if(nums[middle] > nums[i] && nums[middle] > nums[j]){
                    if(target > nums[middle] || target < nums[j]){
                        i = middle + 1;
                    }else{
                        j = middle - 1;
                    }
                }else{
                    if(target > nums[middle]){
                        i = middle + 1;
                    }else{
                        j = middle - 1;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] test = {1,2,3,4,5};
        System.out.println(search(test , 2));
    }
}
