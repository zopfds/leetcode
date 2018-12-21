package leetcode;

import leetcode.util.Println;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/15
 */
public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUn(nums , result , new ArrayList<Integer>() , used);
        return result;
    }

    public static void permuteUn(int[] nums , List<List<Integer>> result , List<Integer> list , boolean[] used){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++){
            if(used[i]){
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            permuteUn(nums , result , list , used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] test = {1,1,2};
        List<List<Integer>> result = permuteUnique(test);
        result.forEach(s -> {
            Println.printArrayList(s);
        });
    }
}
