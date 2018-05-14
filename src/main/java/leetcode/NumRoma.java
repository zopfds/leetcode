package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumRoma {

    private static Map<Character,Integer> numMap= new HashMap<>();
    static{
        numMap.put('I',1);
        numMap.put('V',5);
        numMap.put('X',10);
        numMap.put('L',50);
        numMap.put('C',100);
        numMap.put('D',500);
        numMap.put('M',1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        int i = 0;
        for(; i < s.length() - 1 ; i ++){
            if(numMap.get(s.charAt(i)) < numMap.get(s.charAt(i + 1))){
                result -= numMap.get(s.charAt(i));
            }else{
                result += numMap.get(s.charAt(i));
            }
        }

        result += numMap.get(s.charAt(i));
        return result;
    }

    public static void main(String[] args){
        NumRoma numRoma = new NumRoma();

        System.out.println(numRoma.romanToInt("MCMXCIV"));
    }
}
