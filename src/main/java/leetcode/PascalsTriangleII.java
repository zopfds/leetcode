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
 * @create 2019/1/29
 */
public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastList = Arrays.asList(1);
        if(rowIndex == 0){
            return lastList;
        }
        List<Integer> thisList = new ArrayList<>();
        for(int i = 1 ; i <= rowIndex ; i ++ ){
            thisList = new ArrayList<>();
            int thisCount = 0;
            thisList.add(1);
            thisCount++;
            for(; thisCount < i ; thisCount ++){
                thisList.add(lastList.get(thisCount - 1) + lastList.get(thisCount));
            }
            thisList.add(1);
            lastList = thisList;
        }
        return thisList;
    }

    public static void main(String[] args){
        List<Integer> result = new PascalsTriangleII().getRow(3);
        Println.printArrayList(result);
    }
}
