package leetcode;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/22
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeF(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length);
    }

    private TreeNode buildTreeF(int[] preorder ,int pStart ,int pEnd, int[] intorder , int iStart , int iEnd){
        if(pStart == pEnd){
            return new TreeNode(preorder[pStart]);
        }
        int preStart = preorder[pStart];
        int mIndex = indexOf(intorder , preStart);
        int leftCount = mIndex - iStart;
        int rightCount = iEnd - mIndex - 1;
        TreeNode result = new TreeNode(preStart);
        if(leftCount > 0) {
            result.left = buildTreeF(preorder, pStart + 1, pStart + leftCount, intorder, iStart, iStart + leftCount);
        }
        if(rightCount > 0) {
            result.right = buildTreeF(preorder, pStart + leftCount + 1, pStart + leftCount + rightCount, intorder, mIndex + 1, iEnd);
        }
        return result;
    }

    private int indexOf(int[] t , int target){
        for(int i = 0 ; i < t.length ; i ++){
            if(t[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        System.out.println(new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preorder , inorder));
    }
}
