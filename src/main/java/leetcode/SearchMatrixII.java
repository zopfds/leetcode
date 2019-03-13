package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/2/28
 */
public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix , target , 0 , matrix.length - 1 , 0 , matrix[0].length - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target , int startR , int endR , int startC , int endC){
        if(startR > endR || startC > endC){
            return false;
        }
        while(startR <= endR && startC <= endC){
            int middleR = (startR + endR) / 2 , middleC = (startC + endC) / 2;
            if(matrix[middleR][middleC] == target){
                return true;
            }else if(matrix[middleR][middleC] > target){
                return searchMatrix(matrix , target , startR , middleR - 1 , startC , endC)
                        || searchMatrix(matrix , target , middleR , endR , startC , middleC - 1);
            }else{
                return searchMatrix(matrix , target , middleR + 1 , endR , startC , endC)
                        || searchMatrix(matrix , target , startR , middleR , middleC + 1 , endC);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] testM = new int[5][5];
        testM[0] = new int[]{1,4,7,11,15};
        testM[1] = new int[]{2,5,8,12,19};
        testM[2] = new int[]{3,6,9,16,22};
        testM[3] = new int[]{10,13,14,17,24};
        testM[4] = new int[]{18,21,23,26,30};
        System.out.println(new SearchMatrixII().searchMatrix(testM , 5));
        String test = "{\n" +
                "\t\"days\": 30,\n" +
                "\t\"isPass\": true,\n" +
                "\t\"isInclude\": true\n" +
                "}";
        System.out.println(test);
    }
}
