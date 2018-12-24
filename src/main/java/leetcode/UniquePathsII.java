package leetcode;

import java.util.Arrays;

public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 1 || obstacleGrid[0].length == 1){
            return 1;
        }
        return uniqueP(obstacleGrid , 0 , 0);
    }

    public static int uniqueP(int[][] obstacleGrid , int m , int n){
        if(m == obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1){
            return 1;
        }

        int result = 0;
        if(m + 1 < obstacleGrid.length && obstacleGrid[m + 1][n] != 1){
            result += uniqueP(obstacleGrid , m + 1 , n);
        }
        if(n + 1 < obstacleGrid[0].length && obstacleGrid[m][n + 1] != 1){
            result += uniqueP(obstacleGrid , m , n + 1);
        }
        return result;
    }

    public static void main(String[] args){
        int[][] test = new int[3][2];
        int[] test1 = {0,0};
        int[] test2 = {1,1};
        int[] test3 = {0,0};
        test[0] = test1;
        test[1] = test2;
        test[2] = test3;
        uniquePathsWithObstacles(test);
    }
}
