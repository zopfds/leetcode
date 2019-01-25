package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/25
 */
public class FlattenBinaryTreetoLinkedList {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        TBT(root);
        return;
    }

    private TreeNode TBT(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return root;
        }
        TreeNode right = root.right;
        TreeNode leftTail = root , rightTail = root;
        if(root.left != null){
            leftTail = TBT(root.left);
            root.right = root.left;
            root.left = null;
        }
        if(right != null){
            rightTail = TBT(right);
            leftTail.right = right;
            return rightTail;
        }
        return leftTail;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);

        root.left = root1;
        root1.left = root2;
        new FlattenBinaryTreetoLinkedList().flatten(root);
        System.out.println(root);
    }
}
