package leetcode;

import leetcode.util.Println;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/27
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i <= nums.length ; i ++){
            subsets(result , new ArrayList<Integer>() , nums , 0 , i , 0);
        }
        return result;
    }

    private void subsets(List<List<Integer>> result , List<Integer> list , int[] nums , int start , int n , int count){
        if(count == n){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = start ; i < nums.length ; i ++){
            if(i == start || nums[start] != nums[i]){
                list.add(nums[i]);
                subsets(result , list , nums , i + 1 , n , count + 1);
                start = i;
                list.remove(Integer.valueOf(nums[i]));
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,2,3,3};
        new SubsetsII().subsetsWithDup(nums);
        Println.printArray(nums);
    }
}
