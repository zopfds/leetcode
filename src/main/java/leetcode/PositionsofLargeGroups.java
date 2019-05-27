package leetcode;

import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/5/21
 */
public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        if(S.length() < 3){
            return new ArrayList<>();
        }
        TreeMap<Character , List<Integer>> result = new TreeMap<>((a,b) -> b - a);
        int i = 0 , j = 0 , count = 0;
        while(j < S.length() && i < S.length()){
            if(S.charAt(i) == S.charAt(j)){
                count++;
                j++;
            }else{
                if(count >= 3){
                    result.put(S.charAt(i) , Arrays.asList(i , j - 1));
                }else{
                    i = j;
                }
                count = 0;
            }
        }
        if(count >= 3){
            result.put(S.charAt(i) , Arrays.asList(i , j - 1));
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Iterator<Character> it = result.keySet().iterator();
        while(it.hasNext()){
            resultList.add(result.get(it.next()));
        }
        return resultList;
    }

    public static void main(String[] args){
        String s = "abcdddeeeeaabbbcd";
        System.out.println(new PositionsofLargeGroups().largeGroupPositions(s));
    }
}
