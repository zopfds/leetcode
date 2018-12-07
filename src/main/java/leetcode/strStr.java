package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/6
 */
public class strStr {
    public static int strStr(String haystack, String needle) {
        if(haystack == null){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }

        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = -1 , j = 0;
        while(j < needle.length() - 1){
            if(i == -1 || needle.charAt(i) == needle.charAt(j)){
                if(needle.charAt(i + 1) == needle.charAt(j + 1)){
                    next[++j] = next[++i];
                }else {
                    next[++j] = ++i;
                }
            }else{
                i = next[i];
            }
        }

        i = 0;
        j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == needle.length()){
            return i - j;
        }
        return -1;
    }


    /**
     * 获取next数组,错误案例
     * @return
     */
    public static int[] getNext(String test){
        int[] next = new int[test.length()];
        next[0] = 0;
        int i = 0 , j = 1;

        while(j < test.length()){
            if(test.charAt(i) != test.charAt(j)){
                next[j] = i;
            }else{
                i = next[i];
                while(i != 0 && test.charAt(i) == test.charAt(j)){
                    i = next[i];
                }
                next[j] = i;
            }
            i++;
            j++;
        }
        return next;
    }


    public static void main(String[] args){
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack , needle));
    }
}
