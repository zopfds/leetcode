package leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character , Integer>, List<String>> resultMap = new HashMap<>();
        HashMap<Character , Integer> thisMap = null;
        for(int i = 0 ; i < strs.length ; i ++){
            thisMap = new HashMap<>();
            for(int j = 0 ; j < strs[i].length() ; j ++){
                Integer thisTime = thisMap.get(strs[i].charAt(j));
                if(thisTime == null){
                    thisMap.put(strs[i].charAt(j) , 0);
                }else{
                    thisMap.put(strs[i].charAt(j) , thisTime + 1);
                }
            }
            List<String> thisList = resultMap.get(thisMap);
            if(thisList == null){
                thisList = new ArrayList<>();
            }
            thisList.add(strs[i]);
            resultMap.put(thisMap , thisList);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<HashMap<Character , Integer> , List<String>> entry : resultMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args){

    }
}
