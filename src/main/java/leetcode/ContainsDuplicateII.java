package leetcode;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/5/28
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0){
            return true;
        }
        HashMap<Integer , int[]> indexMap = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            int[] indexList = indexMap.get(nums[i]);
            if(indexList == null){
                indexList = new int[2];
                indexList[0] = i;
                indexList[1] = i;
                indexMap.put(nums[i] , indexList);
            }else{
                indexList[1] = i;
            }
        }
        for(Map.Entry<Integer , int[]> entry : indexMap.entrySet()){
            if(entry.getValue() != null && entry.getValue()[1] - entry.getValue()[0] <= k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,0,1,1};
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums , 1));
    }
}
