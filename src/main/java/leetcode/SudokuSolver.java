package leetcode;

import leetcode.util.Println;

import java.util.HashSet;

public class SudokuSolver {
    static HashSet<Character> fullSet = new HashSet<>();
    static{
        fullSet.add('1');
        fullSet.add('2');
        fullSet.add('3');
        fullSet.add('4');
        fullSet.add('5');
        fullSet.add('6');
        fullSet.add('7');
        fullSet.add('8');
        fullSet.add('9');
    }
    public static void solveSudoku(char[][] board) {
        HashSet<Character>[] parallelNums = new HashSet[board.length];
        HashSet<Character>[] verticalNums = new HashSet[board.length];
        HashSet<Character>[] roundNums = new HashSet[board.length];
        boolean resolve = true;
        for(int i = 0 ; i < board.length ; i ++ ){
            for(int j = 0 ; j < board.length ; j ++){
                if(parallelNums[i] == null){
                    parallelNums[i] = new HashSet<>();
                }

                if (verticalNums[j] == null) {
                    verticalNums[j] = new HashSet<Character>();
                }

                int roundMapNum = (i / 3) * 3 + j / 3;
                if (roundNums[roundMapNum] == null) {
                    roundNums[roundMapNum] = new HashSet<Character>();
                }

                if(board[i][j] != '.') {
                    parallelNums[i].add(board[i][j]);
                    verticalNums[j].add(board[i][j]);
                    roundNums[roundMapNum].add(board[i][j]);
                }else{
                    resolve = false;
                }
            }
        }

        while(!resolve){
            resolve = true;
            for(int i = 0 ; i < board.length ; i ++ ){
                for(int j = 0 ; j < board.length ; j ++){
                    if(board[i][j] == '.') {
                        HashSet<Character> existSet = new HashSet<>();
                        HashSet<Character> thisSet = new HashSet<>(fullSet);
                        existSet.addAll(parallelNums[i]);
                        existSet.addAll(verticalNums[j]);
                        existSet.addAll(roundNums[(i / 3) * 3 + j / 3]);
                        thisSet.removeAll(existSet);
                        if (thisSet.size() == 1) {
                            board[i][j] = thisSet.iterator().next();
                            parallelNums[i].add(board[i][j]);
                            verticalNums[j].add(board[i][j]);
                            roundNums[(i / 3) * 3 + j / 3].add(board[i][j]);
                        }
                        resolve = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        char[][] test = new char[9][9];
        test[0] = new char[]{'.','.','9','7','4','8','.','.','.'};
        test[1] = new char[]{'7','.','.','.','.','.','.','.','.'};
        test[2] = new char[]{'.','2','.','1','.','9','.','.','.'};
        test[3] = new char[]{'.','.','7','.','.','.','2','4','.'};
        test[4] = new char[]{'.','6','4','.','1','.','5','9','.'};
        test[5] = new char[]{'.','9','8','.','.','.','3','.','.'};
        test[6] = new char[]{'.','.','.','8','.','3','.','2','.'};
        test[7] = new char[]{'.','.','.','.','.','.','.','.','6'};
        test[8] = new char[]{'.','.','.','2','7','5','9','.','.'};
        solveSudoku(test);
        for(int i = 0 ; i < test.length ; i ++){
            Println.printArray(test[i]);
        }
    }
}
