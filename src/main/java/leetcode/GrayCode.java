package leetcode;

import java.util.List;

/**
 * 对称二叉树
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/14
 */
public class GrayCode {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSym(root.left , root.right);
    }

    private boolean isSym(TreeNode left , TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null && right != null
                || right == null && left != null
                || left.val != right.val){
            return false;
        }
        return isSym(left.right , right.left) && isSym(left.left , right.right);
    }
}
