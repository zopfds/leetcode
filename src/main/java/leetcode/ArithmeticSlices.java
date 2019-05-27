package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/3/27
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        boolean[] is = new boolean[A.length] , nextIs = new boolean[A.length];
        Arrays.fill(is , true);
        is[0] = false;
        int max = 0;
        for(int i = 2 ; i < A.length ; i ++){
            for(int j = i ; j < A.length ; j ++){
                if(is[j - 1] && A[j] - A[j - 1] == A[j - 1] - A[j - 2]){
                    max++;
                    nextIs[j] = true;
                }else{
                    nextIs[j] = false;
                }
            }
            is = Arrays.copyOf(nextIs , nextIs.length);
            nextIs = new boolean[A.length];
        }
        return max;
    }

    public static void main(String[] args){
        int[] test = {1,2,3,4,5,6};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(test));
    }
}
