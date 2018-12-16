package leetcode;

import leetcode.util.Println;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        rotateFrom(matrix , 0 , 0 , matrix.length);
    }

    private static void rotateFrom(int[][] matrix , int lineNum , int startCNum , int count){
        if(count <= 1){
            return;
        }

        for(int i = 0 ; i < count - 1; i ++){
            int k = matrix[lineNum][startCNum + i];
            matrix[lineNum][startCNum + i] = matrix[lineNum + count - 1 - i][startCNum];
            matrix[lineNum + count - 1 - i][startCNum] = matrix[startCNum + count - 1][startCNum + count - 1 - i];
            matrix[startCNum + count - 1][startCNum + count - 1 - i] = matrix[lineNum + i][startCNum + count - 1];
            matrix[lineNum + i][startCNum + count - 1] = k;
        }

        rotateFrom(matrix , lineNum + 1 , startCNum + 1 , count - 2);
    }

    public static void main(String[] args){
        int[] line1 = {1,2,3,4};
        int[] line2 = {5,6,7,8};
        int[] line3 = {9,10,11,12};
        int[] line4 = {13,14,15,16};
        int[][] test = {line1,line2,line3,line4};
        rotate(test);
        for(int i = 0 ; i < test.length ; i ++){
            Println.printArray(test[i]);
        }
    }
}
