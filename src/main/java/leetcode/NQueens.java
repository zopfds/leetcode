package leetcode;

import leetcode.util.Println;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    private static char[] initLine = null;

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        initLine = new char[n];
        Arrays.fill(initLine , '.');
        int[] queens = new int[n];
        Arrays.fill(queens , -1);
        solveNQ(result , n , queens , new ArrayList<>() , 0);
        return result;
    }

    private static void solveNQ(List<List<String>> result , int n , int[] queens ,List<String> thisList , int lineNum){
        if(thisList.size() == n){
            result.add(new ArrayList<>(thisList));
            return;
        }

        char[] thisLine = new char[n];
        System.arraycopy(initLine , 0 , thisLine , 0 , n);
        boolean[] thisUsed = new boolean[n];
        for(int i = 0 ; i < n ; i ++){
            if(queens[i] == -1){
                break;
            }
            thisUsed[queens[i]] = true;
            if(lineNum - i > 0){
                if(queens[i] - lineNum + i >= 0){
                    thisUsed[queens[i] - lineNum + i] = true;
                }
                if(queens[i] + lineNum - i < n){
                    thisUsed[queens[i] + lineNum - i] = true;
                }
            }
        }
        for(int i = 0 ; i < n ; i ++){
            if(thisUsed[i]){
                thisLine[i] = '.';
                continue;
            }

            queens[lineNum] = i;
            thisLine[i] = 'Q';
            String thisString = new String(thisLine);
            thisList.add(thisString);
            solveNQ(result, n, queens, thisList, lineNum + 1);
            thisList.remove(thisString);
            thisLine[i] = '.';
            queens[lineNum] = -1;
        }
    }

    public static void main(String[] args){
        List<List<String>> result =  solveNQueens(4);
        result.forEach(s -> Println.printStringList(s));
    }
}
