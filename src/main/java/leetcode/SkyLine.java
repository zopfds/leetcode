package leetcode;

public class SkyLine {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] parallel = new int[grid[0].length];
        int[] vertical = new int[grid.length];


        for(int i = 0 ; i < parallel.length ; i++){
            int maxParal = 0;
            for(int j = 0 ; j < vertical.length ; j ++){
                if(grid[j][i] > maxParal){
                    parallel[i] = grid[j][i];
                }
            }
            parallel[i] = maxParal;
        }

        for(int i = 0 ; i < vertical.length ; i++){
            int max = 0;
            for(int j = 0 ; j < parallel.length ; j ++){
                if(grid[i][j] > max){
                    max = grid[i][j];
                }
            }
            vertical[i] = max;
        }

        int result = 0;
        for(int i = 0 ; i < vertical.length ; i ++ ){
            for(int j = 0 ; j < parallel.length ; j ++){
                result += (vertical[i] > parallel[j] ? parallel[j] : vertical[i]) - grid[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args){
        SkyLine skyLine = new SkyLine();
        int[][] grid = new int[][]{{59,88,44},{3,18,38},{21,26,51}};
        skyLine.maxIncreaseKeepingSkyline(grid);
    }


}
