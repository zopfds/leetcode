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
public class BinaryTreeZigzagLevelOrderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offerFirst(root);
        boolean order = false;
        int lastCount = 1 , count = 1;
        while(queue.size() != 0 || stack.size() != 0){
            List<Integer> resultList = new ArrayList<>();
            lastCount = count;
            count = 0;
            while((queue.size() != 0 || stack.size() != 0)&& lastCount > 0){
                TreeNode node = order ? stack.pollFirst() : queue.pollFirst() ;
                if(node != null) {
                    resultList.add(node.val);
                    if(!order){
                        stack.offerFirst(node.left);
                        stack.offerFirst(node.right);
                    }else{
                        queue.offerFirst(node.right);
                        queue.offerFirst(node.left);
                    }
                    count = count + 2;
                }
                lastCount--;
            }
            order = !order;
            if(resultList.size() != 0) {
                result.add(resultList);
            }
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root2.right = root4;

        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));

    }
}
