package leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        StringBuilder result = new StringBuilder();

        int minLength = strs[0].length();
        int index = 0;

        for(int i = 0 ; i < strs.length; i ++ ){
            if(strs[i].length() < minLength){
                minLength = strs[i].length();
                index = i;
            }
        }

        if(minLength == 0){
            return "";
        }

        for(int i = 0 ; i < minLength ; i ++){
            char common = strs[0].charAt(i);
            for(int j = 1 ; j < strs.length ; j ++){
                if(common != strs[j].charAt(i)){
                    return result.toString();
                }
            }
            result.append(common);
        }

        return result.toString();
    }

    public String longestCommonPrefix1(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        String prefix = strs[0];

        for(int i = 1 ; i < strs.length ; i ++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0 , prefix.length() - 1);
                if(prefix.equals("")){
                    return "";
                }
            }
        }

        return prefix;
    }

//    public static void main(String[] args){
//        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//
//        String strs[] =
//
//        System.out.println();
//    }

}
