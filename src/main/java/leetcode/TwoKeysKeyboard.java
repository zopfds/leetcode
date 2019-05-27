package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/1
 */
public class TwoKeysKeyboard {
    public int minSteps(int n) {
        if(n <= 1){
            return 0;
        }else if(n <= 3){
            return n;
        }
        int[] result = new int[n + 1];
        result[1] = 0;
        for(int i = 2 ; i < n + 1; i ++){
            result[i] = i;
            for(int j = i / 2 ; j >= 1 ; j --){
                if(i % j == 0) {
                    result[i] = Math.min(result[i], result[j] + i / j);
                }
            }
        }
        return result[n];
    }

    public static void main(String[] args){
        System.out.println(new TwoKeysKeyboard().minSteps(11));
    }
}
