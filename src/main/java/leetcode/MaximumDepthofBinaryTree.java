package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/21
 */
public class MaximumDepthofBinaryTree {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return maxDepthD(root , 1);
    }

    private int maxDepthD(TreeNode root , int depth){
        if(root == null){
            return depth;
        }

        int leftDepth = depth , rightDepth = depth;
        if(root.left != null){
            leftDepth = maxDepthD(root.left , depth + 1);
        }
        if(root.right != null){
            rightDepth = maxDepthD(root.right , depth + 1);
        }
        return Math.max(leftDepth , rightDepth);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(7);

        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;

        System.out.println(new MaximumDepthofBinaryTree().maxDepth(root));
    }
}
