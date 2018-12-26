package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/26
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        com(result , new ArrayList<Integer>() , n , 1 , k);
        return result;
    }

    private void com(List<List<Integer>> result , List<Integer> list , int n , int start , int k){
        if(k == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = start ; i <= n ; i ++){
            list.add(i);
            com(result , list , n , i + 1 , k - 1);
            list.remove(Integer.valueOf(i));
        }
    }
}
