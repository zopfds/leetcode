package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/16
 */
public class SumSubarrayMins {
    public int sumSubarrayMins(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }else if(A.length == 1){
            return A[0];
        }
        int[][] result = new int[A.length][A.length];
        int sum = 0;
        for(int i = 0 ; i < A.length ; i ++){
            result[i][i] = A[i];
            sum += result[i][i];
        }
        for(int count = 1 ; count < A.length ; count ++){
            for(int i = 0 ; i < A.length - count ; i ++){
                int j = count + i;
                result[i][j] = Math.min(result[i + 1][j] , result[i][j - 1]);
                sum += result[i][j];
            }
        }
        return sum % ((int) Math.pow(10 , 9) + 7);
    }

    public static void main(String[] args){
        int[] test = new int[]{59 , 91};
        System.out.println(new SumSubarrayMins().sumSubarrayMins(test));
    }
}
