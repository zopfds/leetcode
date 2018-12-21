package leetcode;

import java.util.Arrays;

public class NQueensII {
    private static boolean[] initUsed;
    public int totalNQueens(int n) {
        initUsed = new boolean[n];
        Arrays.fill(initUsed , false);
        int[] queens = new int[n];
        Arrays.fill(queens , -1);
        return totalN(queens , 0 , n);
    }

    public int totalN(int[] queens , int lineNum , int n){
        if(lineNum == n){
            return 1;
        }

        boolean[] thisUsed = new boolean[n];
        System.arraycopy(initUsed , 0 , thisUsed , 0 , n);
        for(int i = 0 ; i < queens.length ; i ++){
            if(queens[i] == -1){
                break;
            }
            thisUsed[queens[i]] = true;
            int leftIndex = queens[i] - lineNum + i;
            if(leftIndex >= 0){
                thisUsed[leftIndex] = true;
            }
            int rightIndex = queens[i] + lineNum - i;
            if(rightIndex < n){
                thisUsed[rightIndex] = true;
            }
        }

        int result = 0;
        for(int i = 0 ; i < n ; i ++){
            if(thisUsed[i]){
                continue;
            }

            thisUsed[i] = true;
            queens[lineNum] = i;
            result += totalN(queens , lineNum + 1 , n);
            thisUsed[i] = false;
            queens[lineNum] = -1;
        }

        return result;
    }

    public static void main(String[] args){

    }
}
