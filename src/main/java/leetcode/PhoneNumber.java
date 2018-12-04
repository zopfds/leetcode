package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class PhoneNumber {

    private static Map<Integer , char[]> numMap = new HashMap<>();

    static{
        numMap.put(2 , new char[]{'a','b','c'});
        numMap.put(3 , new char[]{'d','e','f'});
        numMap.put(4 , new char[]{'g','i','h'});
        numMap.put(5 , new char[]{'j','k','l'});
        numMap.put(6 , new char[]{'m','n','o'});
        numMap.put(7 , new char[]{'p','q','r','s'});
        numMap.put(8 , new char[]{'t','u','v'});
        numMap.put(9 , new char[]{'w','x','y','z'});
    }

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        appendChar(chars , 0 , "" , result);
        return result;
    }

    public static void appendChar(char[] chars , int index , String s , List<String> resultSet){
        char[] charSet = numMap.get(chars[index] - '0');
        if(index == chars.length - 1){
            if(charSet != null){
                for(int i = 0 ; i < charSet.length ; i ++ ){
                    resultSet.add(s + charSet[i]);
                }
            }
            return;
        }else{
            for(int i = 0 ; i  < charSet.length ; i ++){
                appendChar(chars , index + 1 , s + charSet[i] , resultSet);
            }
        }
    }

    public static void main(String[] args){
        String test = "23";
        List<String> resultList = letterCombinations(test);
        resultList.forEach(s -> System.out.println(s));
    }
}
