package leetcode;

import leetcode.util.Println;

import java.util.*;

/**
 * 全排列
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/13
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i ++){
            numsList.add(nums[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        getPermute(result,  new ArrayList<>() , numsList);
        return result;
    }

    public static void getPermute(List<List<Integer>> result , List<Integer> list , List<Integer> nums){
        if(nums.size() == 0){
            result.add(list);
            return;
        }

        for(int i = 0 ; i < nums.size() ; i ++){
            List<Integer> thisList = new ArrayList<>(list);
            List<Integer> thisNums = new ArrayList<>(nums);
            Integer thisNum = thisNums.remove(i);
            thisList.add(thisNum);
            getPermute(result , thisList , thisNums);
        }
    }

    public static void main(String[] args){
        int[] test = {1,2,3,4};
        List<List<Integer>> result =  permute(test);
        result.forEach(s -> {
            Println.printArrayList(s);
        });
    }

}
