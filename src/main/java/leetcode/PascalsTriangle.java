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
 * @create 2019/1/28
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0){
            return result;
        }
        result.add(Arrays.asList(1));
        for(int i = 1 ; i < numRows ; i ++ ){
            List<Integer> thisList = new ArrayList<>() , lastList = result.get(i - 1);
            int thisCount = 0;
            thisList.add(1);
            thisCount++;
            for(; thisCount < i ; thisCount ++){
                thisList.add(lastList.get(thisCount - 1) + lastList.get(thisCount));
            }
            thisList.add(1);
            result.add(thisList);
        }
        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> result = new PascalsTriangle().generate(3);
        result.forEach(list -> Println.printArrayList(list));
    }
}
