package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/11
 */
public class CountandSay {
    /**
     * 数并且计数
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if(n < 2){
            return "1";
        }
        StringBuffer sb = new StringBuffer("11");
        StringBuffer result = new StringBuffer();
        for(int i = 0 ; i < n - 2 ; i ++ ){
            int count = 0;
            for(int j = 0 ; j < sb.length(); j ++){
                if(j != sb.length() - 1 && sb.charAt(j) == sb.charAt(j+1)){
                    count++;
                }else{
                    result.append(++count);
                    result.append(sb.charAt(j));
                    count = 0;
                }
            }
            sb = result;
            result = new StringBuffer();
        }

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(countAndSay(6));
    }
}
