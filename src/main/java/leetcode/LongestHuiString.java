package leetcode;

public class LongestHuiString{
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        if(s.length() == 1){
            return s;
        }

        int maxStart = 0 , maxEnd = 0 , i = 1;

        int l = -1;

        while(i < s.length()){

            int j = l == -1 ? i - 1 : i , k = i;

            while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }

            if((k - 1) - (j + 1) > maxEnd - maxStart){
                maxEnd = k - 1;
                maxStart = j + 1;
            }

            if(l == 1){
                i++;
            }

            l = -l;

            if(s.length() - i < (maxEnd - maxStart + 1) / 2){
                break;
            }
        }

        return s.substring(maxStart , maxEnd + 1);
    }

    public static void main(String[] args){
        LongestHuiString test  = new LongestHuiString();

        System.out.println(test.longestPalindrome("ccc"));
    }
}
