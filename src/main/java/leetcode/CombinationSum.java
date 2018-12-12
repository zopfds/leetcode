package leetcode;

import leetcode.util.Println;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/12
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        searchSum(result , new ArrayList<Integer>() , candidates , target , 0);
        return result;
    }

    public static void searchSum(List<List<Integer>> result , List<Integer> list , int[] candidates , int target , int start){
        if(target == 0){
            result.add(list);
            return;
        }

        for(int i = start ; i < candidates.length ; i ++){
            List<Integer> copyList = new ArrayList<Integer>(list);
            if(target - candidates[i] >= 0){
                copyList.add(candidates[i]);
            }else{
                return;
            }
            searchSum(result , copyList , candidates , target - candidates[i] , i);
        }
    }

    public static void main(String[] args){
        int[] test = {2,3,6,7};
        List<List<Integer>> result = combinationSum(test , 7);
        result.forEach(s -> {
            Println.printArrayList(s);
        });
    }
}
