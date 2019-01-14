package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/2
 */
public class ValidateBinarySearchTree {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    double last = - Double.MAX_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }

        if(isValidBST2(root.left)){
            if(last < root.val){
                last = root.val;
                return isValidBST2(root.right);
            }
        }
        return false;
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidB(root , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    private static boolean isValidB(TreeNode root , int min , int max){
        if(root == null){
            return true;
        }

        if(min >= max || root.val <= min || root.val >= max){
            return false;
        }

        boolean left = true , right = true;
        if(root.left != null){
            if(root.val > root.left.val){
                left = isValidB(root.left , min , Math.min(root.val , max));
            }else{
                return false;
            }
        }

        if(root.right != null){
            if(root.val < root.right.val){
                right = isValidB(root.right , Math.max(root.val , min) , max);
            }else{
                return false;
            }
        }

        return left && right;
    }

    public static void main(String[] args){
//        TreeNode root = new TreeNode(3);
//        TreeNode root1 = new TreeNode(1);
//        TreeNode root2 = new TreeNode(5);
//        TreeNode root3 = new TreeNode(0);
//        TreeNode root4 = new TreeNode(2);
//        TreeNode root5 = new TreeNode(4);
//        TreeNode root6 = new TreeNode(6);
//        TreeNode root7 = new TreeNode(3);
//
//
//        root.left = root1;
//        root.right = root2;
//        root1.left = root3;
//        root1.right = root4;
//        root2.left = root5;
//        root2.right = root6;
//        root5.left = root7;

        TreeNode root = new TreeNode(-2147483648);
        TreeNode root1 = new TreeNode(2147483647);
        TreeNode root2 = new TreeNode(-2147483648);

        root.left = null;
        root.right = root1;
        root1.left = root2;

        System.out.println(isValidBST(root));
    }
}
