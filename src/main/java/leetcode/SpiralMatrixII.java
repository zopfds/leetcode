package leetcode;

/**
 * 螺旋矩阵
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/21
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int length = n - 1 , startIndex = 0 , count = 0;
        while(length >= 1){
            for(int i = 0 ; i < length ; i ++){
                result[startIndex][startIndex + i] = ++count;
            }
            for(int i = 0 ; i < length ; i ++){
                result[startIndex + i][n - 1 - startIndex] = ++count;
            }
            for(int i = 0 ; i < length ; i ++){
                result[n - 1 - startIndex][n - 1 - startIndex - i] = ++count;
            }
            for(int i = 0 ; i < length ; i ++){
                result[n - 1 - startIndex - i][startIndex] = ++count;
            }
            startIndex ++;
            length -= 2;
        }
        if(length == 0){
            result[startIndex][startIndex] = ++count;
        }
        return result;
    }
}
