package leetcode;

/**
 * 最后单词的长度
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/21
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1,endIndex = -1;
        while(i >= 0){
            if(s.charAt(i) == ' '){
                if(endIndex != -1){
                    return endIndex - i;
                }
            }else{
                if(endIndex == -1){
                    endIndex = i;
                }
            }
            i--;
        }
        return endIndex == -1 ? 0 : endIndex - i;
    }

    public static void main(String[] args){

    }
}
