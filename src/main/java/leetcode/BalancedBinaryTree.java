package leetcode;

/**
 * 判断是否为平衡二叉树
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/23
 */
public class BalancedBinaryTree {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    private static boolean isTrue = true;
    public boolean isBalanced(TreeNode root) {
        isTrue = true;
        isBalancedF(root);
        return isTrue;
    }

    private int isBalancedF(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int leftDepth = 1 , rightDepth = 1;
        if(root.left != null){
            leftDepth = isBalancedF(root.left) + 1;
        }
        if(root.right != null){
            rightDepth = isBalancedF(root.right) + 1;
        }
        if(leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1){
            isTrue = false;
        }
        return Math.max(leftDepth , rightDepth);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(4);

        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root3.left = root5;
        root3.right = root6;

        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }
}
