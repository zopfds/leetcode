package leetcode;

import java.util.HashSet;

/**
 * 设置0
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/25
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> lineSet = new HashSet<Integer>();
        HashSet<Integer> columnSet = new HashSet<Integer>();
        for(int i = 0 ; i < matrix.length ; i ++){
            for(int j = 0 ; j < matrix[0].length ; j ++){
                if(matrix[i][j] == 0){
                    lineSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for(int i = 0 ; i < matrix.length ; i ++){
            if(lineSet.contains(i)){
                for(int j = 0 ; j < matrix[0].length ; j ++){
                    matrix[i][j] = 0;
                }
            }else{
                for(int j = 0 ; j < matrix[0].length ; j ++){
                    if(columnSet.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return;
    }
}
