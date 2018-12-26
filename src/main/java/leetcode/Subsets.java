package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/26
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i <= nums.length ; i ++){
            subset(result , 0 , i , new ArrayList<Integer>() , nums);
        }
        return result;
    }

    private void subset(List<List<Integer>> result , int start , int k , List<Integer> list , int[] nums){
        if(k == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = start ; i < nums.length ; i ++){
            list.add(nums[i]);
            subset(result , i + 1 , k - 1 , list , nums);
            list.remove(Integer.valueOf(nums[i]));
        }
    }
}
