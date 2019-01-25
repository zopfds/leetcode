package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/25
 */
public class MinimumDepthofBinaryTree {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        }else if(root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }else{
            return Math.min(minDepth(root.left) + 1 , minDepth(root.right) + 1);
        }
    }

    public static void main(String[] args){
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node2.right = node4;
        System.out.println(new MinimumDepthofBinaryTree().minDepth(node));
    }
}
