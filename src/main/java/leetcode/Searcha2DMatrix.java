package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/25
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = 0 , j = matrix.length - 1;
        while(i < j){
            int middle = (i + j) / 2;
            if(matrix[middle][0] < target){
                if(target < matrix[middle][matrix[0].length - 1]){
                    i = middle;
                    break;
                }else if(target > matrix[middle][matrix[0].length - 1]){
                    i = middle + 1;
                }else{
                    return true;
                }
            }else if(matrix[middle][0] > target){
                j = middle - 1;
            }else{
                return true;
            }
        }

        if(matrix[i][matrix[0].length - 1] < target){
            return false;
        }

        int column = i;
        i = 0 ;
        j = matrix[0].length - 1;
        while(i < j){
            int middle = (i + j) / 2;
            if(matrix[column][middle] < target){
                i = middle + 1;
            }else if(matrix[column][middle] > target){
                j = middle - 1;
            }else{
                return true;
            }
        }
        return matrix[column][i] == target;
    }

    public static void main(String[] args){
        int[][] test = new int[3][4];
        int[] test1 = {1,3,5,7};
        int[] test2 = {10,11,16,20};
        int[] test3 = {23,30,34,50};
        test[0] = test1;
        test[1] = test2;
        test[2] = test3;
        System.out.println(new Searcha2DMatrix().searchMatrix(test , 13));
    }
}
