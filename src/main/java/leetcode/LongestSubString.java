package leetcode;

import leetcode.util.Println;

/**
 * leetcode最长子串
 */
public class LongestSubString{

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int max = 1 , i = 0 , j = 0;

        while(i < s.length()){

            j = i;

            boolean dup = false;

            while(j < s.length() && dup == false){

                int index = i;

                for(; index < j ; index ++){
                    if(s.charAt(index) == s.charAt(j)){
                        dup = true;
                        break;
                    }
                }

                if(index - i + 1 > max){
                    max = index - i + 1;
                }

                j++;
            }

            i++;
        }

        return max;
    }

    public static void main(String[] args){
        LongestSubString longestSubString = new LongestSubString();

        String test = "ab";

        System.out.println((int) 'a');

        System.out.println(longestSubString.lengthOfLongestSubstring(test));

    }
}
