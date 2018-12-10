package leetcode;

import java.util.HashSet;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> nums = new HashSet<Character>();
        HashSet<Character>[] verticalNums = new HashSet[board.length];
        HashSet<Character>[] roundNums = new HashSet[board.length];
        for(int i = 0 ; i < board.length ; i ++ ){
            nums.clear();
            for(int j = 0 ; j < board.length ; j ++){
                if(board[i][j] != '.') {
                    if (nums.contains(board[i][j])) {
                        return false;
                    } else {
                        nums.add(board[i][j]);
                    }

                    HashSet<Character> vertical = verticalNums[j];
                    if (vertical == null) {
                        verticalNums[j] = new HashSet<Character>();
                        verticalNums[j].add(board[i][j]);
                    } else {
                        if (vertical.contains(board[i][j])) {
                            return false;
                        } else {
                            vertical.add(board[i][j]);
                        }
                    }

                    int roundMapNum = (i / 3) * 3 + j / 3;
                    if (roundNums[roundMapNum] == null) {
                        roundNums[roundMapNum] = new HashSet<Character>();
                        roundNums[roundMapNum].add(board[i][j]);
                    } else {
                        if (roundNums[roundMapNum].contains(board[i][j])) {
                            return false;
                        } else {
                            roundNums[roundMapNum].add(board[i][j]);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        char[][] test = new char[9][9];
        test[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        test[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        test[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        test[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        test[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        test[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        test[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        test[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        test[8] = new char[]{'.','.','.','.','8','.','.','7','9'};
        System.out.println(isValidSudoku(test));
    }
}
