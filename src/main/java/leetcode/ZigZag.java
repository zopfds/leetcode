package leetcode;

public class ZigZag {
    public String convert(String s, int numRows) {
        if(s=="" || numRows < 2){
            return s;
        }

        int moduleNum = (numRows - 1) << 1;

        int modCount = s.length() / moduleNum;

        int moduleCount = s.length() % moduleNum == 0 ? modCount : modCount + 1;

        StringBuilder result = new StringBuilder();

        for(int j = 0 ; j < moduleCount ; j ++){
            result.append(s.charAt(j * moduleNum));
        }

        for(int i = 1 ; i < numRows - 1 ; i ++){
            for(int j = 0 ; j < moduleCount ; j++){

                int k = i + j * moduleNum;
                if(k < s.length()) {
                    result.append(s.charAt(k));
                }

                int l = (j + 1) * moduleNum - i;
                if(l < s.length()) {
                    result.append(s.charAt(l));
                }
            }
        }

        for(int m = 0; m < moduleCount ; m ++){
            int n = numRows - 1 + m * moduleNum;
            if(n < s.length()){
                result.append(s.charAt(n));
            }
        }

        return result.toString();
    }
}



