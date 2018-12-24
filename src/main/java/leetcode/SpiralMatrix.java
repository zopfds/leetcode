package leetcode;

import leetcode.util.Println;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        spiralO(result , 0 , matrix);
        return result;
    }

    public static void spiralO(List<Integer> result , int startRow , int[][] matrix){
        int lineCount =  matrix[0].length - startRow * 2;
        int rowCount = matrix.length - startRow * 2;
        if(rowCount == 1){
            for(int i = 0 ; i < lineCount ; i ++){
                result.add(matrix[startRow][startRow + i]);
            }
            return;
        }
        if(lineCount == 1){
            for(int i = 0 ; i < rowCount ; i ++){
                result.add(matrix[startRow + i][startRow]);
            }
            return;
        }
        if(Math.min(lineCount , rowCount) <= 0) {
            return;
        }
        for(int i = 0 ; i < lineCount - 1; i++){
            result.add(matrix[startRow][startRow + i]);
        }
        for(int i = 0 ; i < rowCount - 1 ; i++){
            result.add(matrix[startRow + i][startRow + lineCount - 1]);
        }
        for(int i = 0 ; i < lineCount - 1 ; i ++){
            result.add(matrix[startRow + rowCount - 1][startRow + lineCount - 1 - i]);
        }
        for(int i = 0 ; i < rowCount - 1 ;i ++){
            result.add(matrix[startRow + rowCount - 1 - i][startRow]);
        }

        spiralO(result , startRow + 1 , matrix);
    }

    public static void main(String[] args){
        int[] test1 = {1,2,3,4};
        int[] test2 = {5,6,7,8};
        int[] test3 = {9,10,11,12};
        int[][] testM = {test1, test2 , test3};
        List<Integer> result = spiralOrder(testM);
        Println.printArrayList(result);
    }
}
