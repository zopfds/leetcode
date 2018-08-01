package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Jewels {

    public int numJewelsInStones(String J, String S) {

        if(J.length() == 0 || S.length() == 0){
            return 0;
        }

        int[] jewelsList = new int[58];

        for(int i = 0 ; i < J.length() ; i ++ ){
            jewelsList[J.charAt(i) - 65] = 1;
        }

        int result = 0 ;

        for(int i = 0 ; i < S.length() ; i ++){
            if(jewelsList[S.charAt(i) - 65] == 1){
                result ++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Jewels jewels = new Jewels();

        System.out.println(jewels.numJewelsInStones("aA","aAAbbbb"));

        System.out.println((int)'A');
    }
}
