package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;

public class TreeSearch {

    /**
     * 中序遍历
     * @param root
     */
    public static void LDR(TreeNode root){

        if(root == null){
            return;
        }

        //栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode peek = root;
        while(!stack.isEmpty() || peek != null){
            while(peek != null){
                stack.push(peek);
                peek = peek.getLeftNode();
            }

            peek = stack.pop();
            System.out.println(peek.getValue());
            peek = peek.getRightNode();
        }

    }

    public static void main(String[] args){
        TreeNode<Integer> root = new TreeNode<Integer>(4);

        TreeNode<Integer> left = new TreeNode<>(2);
        TreeNode<Integer> right = new TreeNode<>(5);
        TreeNode<Integer> leftleft = new TreeNode<>(1);
        TreeNode<Integer> leftright = new TreeNode<>(3);
        TreeNode<Integer> rightleft = new TreeNode<>(6);
        TreeNode<Integer> rightright = new TreeNode<>(7);

        root.setLeftNode(left);
        root.setRightNode(right);
        left.setLeftNode(leftleft);
        left.setRightNode(leftright);
        right.setLeftNode(rightleft);
        right.setRightNode(rightright);

        LDR(root);

    }
}
