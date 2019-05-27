package leetcode;

import java.util.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/15
 */
public class MaxArea {
    static class Node{
        int x;
        int y;
        int dirc;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        LinkedList<Node> stack = new LinkedList<>();
        int maxCount = 0;
        for(int i = 0 ; i < grid.length ; i ++){
            for(int j = 0 ; j < grid[0].length ; j ++){
                if(grid[i][j] == 0){
                    continue;
                }
                stack.addFirst(new Node(i , j));
                int thisCount = 0;
                while(!stack.isEmpty()){
                    Node top = stack.peekFirst();
                    grid[top.x][top.y] = 0;
                    if(top.dirc == 0){
                        if(top.x != 0 && grid[top.x - 1][top.y] != 0){
                            stack.addFirst(new Node(top.x - 1, top.y));
                            top.dirc ++;
                            continue;
                        }
                        top.dirc ++;
                    }

                    if(top.dirc == 1){
                        if(top.y != grid[0].length - 1 && grid[top.x][top.y + 1] != 0){
                            stack.addFirst(new Node(top.x , top.y + 1));
                            top.dirc ++;
                            continue;
                        }
                        top.dirc ++;
                    }

                    if(top.dirc == 2){
                        if(top.x != grid.length - 1 && grid[top.x + 1][top.y] != 0){
                            stack.addFirst(new Node(top.x + 1 , top.y));
                            top.dirc ++;
                            continue;
                        }
                        top.dirc ++;
                    }

                    if(top.dirc == 3){
                        if(top.y != 0 && grid[top.x][top.y - 1] != 0){
                            stack.addFirst(new Node(top.x , top.y - 1));
                            top.dirc ++;
                            continue;
                        }
                        top.dirc ++;
                    }

                    if(top.dirc == 4){
                        thisCount ++;
                        stack.removeFirst();
                    }
                }
                if(thisCount > maxCount){
                    maxCount = thisCount;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args){
        int[][] test = new int[4][5];
        test[0] = new int[]{1,1,0,0,0};
        test[1] = new int[]{1,1,0,0,0};
        test[2] = new int[]{0,0,0,1,1};
        test[3] = new int[]{0,0,0,1,1};
        System.out.println(new MaxArea().maxAreaOfIsland(test));
    }
}
