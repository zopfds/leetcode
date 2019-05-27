package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/19
 */
public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        char[] schars = S.toCharArray();
        int top = -1,count = 0;
        for(int i = 0 ; i < schars.length ; i++){
            if(schars[i] == '('){
                top ++;
            }else{
                if(top != -1){
                    top--;
                }else{
                    count++;
                }
            }
        }
        return count + top + 1;
    }

    public static void main(String[] args){
        String s = "()))((";
        System.out.println(new MinimumAddtoMakeParenthesesValid().minAddToMakeValid(s));
    }
}
