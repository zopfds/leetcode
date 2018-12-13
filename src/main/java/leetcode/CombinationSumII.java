package leetcode;

import leetcode.util.Println;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/12
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(candidates.length);
        for(int i = 0 ; i < candidates.length ; i ++){
            if(candidates[i] <= target){
                Integer thisCount = hashMap.get(candidates[i]);
                if(thisCount == null){
                    thisCount = 1;
                }else{
                    thisCount ++;
                }
                hashMap.put(candidates[i] , thisCount);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        combinate(result , new ArrayList<Integer>() , hashMap , target);
        return result;
    }

    public static void combinate(List<List<Integer>> result , List<Integer> list , HashMap<Integer , Integer> map, int target){
        if(target == 0){
            result.add(list);
            return;
        }

        HashMap<Integer , Integer> thisMap = new HashMap<>(map);
        for(Map.Entry<Integer , Integer> entry : thisMap.entrySet()){
            List<Integer> thisList = new ArrayList<>(list);
            int thisTarget = target - entry.getKey();
            if(entry.getValue() > 0) {
                if (thisTarget > 0) {
                    thisList.add(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    combinate(result, thisList, thisMap, thisTarget);
                } else if (thisTarget == 0) {
                    thisList.add(entry.getKey());
                    result.add(thisList);
                    return;
                } else {
                    return;
                }
            }
            entry.setValue(0);
        }
    }

    public static void main(String[] args){
        int[] test = {2,5,2,1,2};
        List<List<Integer>> result = combinationSum2(test , 5);
        result.forEach(s -> {
            Println.printArrayList(s);
        });
    }
}
