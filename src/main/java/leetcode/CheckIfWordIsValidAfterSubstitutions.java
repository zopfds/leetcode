package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/29
 */
public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String S) {
        char[] stack = new char[S.length()];
        int top = -1 , i = 0;
        while(i < S.length()){
            while(i < S.length() && S.charAt(i) != 'c'){
                stack[++top] = S.charAt(i++);
            }
            if(top < 1){
                return false;
            }
            if(i < S.length() && stack[top] == 'b' && stack[top-1] == 'a'){
                top = top - 2;
                i++;
            }else{
                return false;
            }
        }
        return top == -1;
    }

    public static void main(String[] args){
        System.out.println(new CheckIfWordIsValidAfterSubstitutions().isValid("abcab"));
    }
}
