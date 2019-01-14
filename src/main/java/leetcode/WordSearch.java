package leetcode;

import leetcode.util.Println;

import java.util.LinkedList;

/**
 * 搜索单词
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/8
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int[] nextVal = getNextVal(word);
        LinkedList<Integer> stack = new LinkedList<>();
        return false;
    }

    public boolean existF(char[][] board, boolean[][] used , String word , int i , int j , LinkedList<Integer> stack, int index){
        if(index == word.length()){
            return true;
        }

        if(board[i][j] == word.charAt(index)){
            stack.push(0);
            used[i][j] = true;
            boolean up = false , down =  false , left = false,  right = false;
            if(j - 1 >= 0 && !used[i][j - 1]){
                up = existF(board , used , word + board[i][j] , i , j - 1 , stack , index + 1);
            }
            if(i + 1 < board[0].length && !used[i + 1][j]){
                right = existF(board , used , word + board[i + 1][j] , i + 1, j , stack , index + 1);
            }
            if(j + 1 < board.length && !used[i][j + 1]){
                down = existF(board , used , word + board[i][j + 1] , i, j + 1 , stack , index + 1);
            }
            if(i - 1 >= 0 && !used[i - 1][j]){
                left = existF(board , used , word + board[i][j + 1] , i - 1, j , stack , index + 1);
            }
            return false;
        }

        return false;
    }

    private int[] getNext(String word){
        int[] result = new int[word.length()];
        result[0] = -1;
        int i = -1 , j = 0;
        while(j < word.length() - 1){
            if(i == -1 || word.charAt(i) == word.charAt(j)){
                result[++j] = ++i;
            }else{
                i = result[i];
            }
        }
        return result;
    }

    private int[] getNextVal(String word){
        int[] result = new int[word.length()];
        result[0] = -1;
        int i = -1 , j = 0;
        while(j < word.length() - 1){
            if(i == -1 || word.charAt(i) == word.charAt(j)){
                if(word.charAt(i + 1) == word.charAt(j + 1)){
                    result[++j] = result[++i];
                }else{
                    result[++j] = ++i;
                }
            }else{
                i = result[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        Println.printArray(new WordSearch().getNextVal("ababaaababaa"));
        Println.printArray(new WordSearch().getNext("ababaaababaa"));
    }
}
