package leetcode;

import java.util.*;

public class RomaNum{

    private static Map<Integer,String> numMap= new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    static{
        numMap.put(1,"I");
        numMap.put(4,"IV");
        numMap.put(5,"V");
        numMap.put(9,"IX");
        numMap.put(10,"X");
        numMap.put(40,"XL");
        numMap.put(50,"L");
        numMap.put(90,"XC");
        numMap.put(100,"C");
        numMap.put(400,"CD");
        numMap.put(500,"D");
        numMap.put(900,"CM");
        numMap.put(1000,"M");
    }



    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Integer, String> it : numMap.entrySet()){
            int count = num / it.getKey();
            for(int j = 0 ; j < count ; j ++){
                sb.append(it.getValue());
            }
            num = num - it.getKey() * count;
        }

        return sb.toString();
    }

    public static void main(String[] args){
        RomaNum romaNum = new RomaNum();

        System.out.print(romaNum.intToRoman(1994));
    }
}
