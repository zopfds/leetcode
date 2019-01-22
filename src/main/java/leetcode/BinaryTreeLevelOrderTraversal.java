package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/14
 */
public class BinaryTreeLevelOrderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.addLast(root);
        int lastCount = 1 , count = 1;
        while(queue.size() != 0){
            List<Integer> resultList = new ArrayList<>();
            lastCount = count;
            count = 0;
            while(queue.size() != 0 && lastCount > 0){
                TreeNode node = queue.pollFirst();
                resultList.add(node.val);
                if(node.left != null){
                    queue.addLast(node.left);
                    count ++;
                }
                if(node.right != null){
                    queue.addLast(node.right);
                    count ++;
                }
                lastCount--;
            }
            result.add(resultList);
        }
        return result;
    }

    public static void main(String[] args){

    }
}
