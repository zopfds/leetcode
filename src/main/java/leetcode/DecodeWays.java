package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/27
 */
public class DecodeWays {
    public int numDecodings(String s) {
        return numDe(s , 0);
    }

    private int numDe(String s , int start){
        if(start >= s.length()){
            return 1;
        }

        int result = 0;
        if(s.charAt(start) > '0'){
            result += numDe(s , start + 1);
        }
        if(start < s.length() - 1 && (s.charAt(start) > '0' && s.charAt(start) < '2'
                || (s.charAt(start) == '2' && s.charAt(start + 1) <= '6'))){
            result += numDe(s , start + 2);
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new DecodeWays().numDecodings("1"));
    }
}
