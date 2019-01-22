package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/22
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        return buildTreeF(postorder , 0 , postorder.length - 1 , inorder , 0 , inorder.length - 1);
    }

    private TreeNode buildTreeF(int[] postorder ,int pStart ,int pEnd, int[] intorder , int iStart , int iEnd){
        if(pStart == pEnd){
            return new TreeNode(postorder[pStart]);
        }
        int postEnd = postorder[pEnd];
        int mIndex = indexOf(intorder , postEnd);
        int leftCount = mIndex - iStart;
        int rightCount = iEnd - mIndex;
        TreeNode result = new TreeNode(postEnd);
        if(leftCount > 0) {
            result.left = buildTreeF(postorder, pStart, pStart + leftCount - 1, intorder, iStart, iStart + leftCount - 1);
        }
        if(rightCount > 0) {
            result.right = buildTreeF(postorder, pStart + leftCount, pEnd  - 1, intorder, mIndex + 1, iEnd);
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
        int[] postorder = {3,2,1};
        int[] inorder = {3,2,1};
        System.out.println(new ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(inorder , postorder));
    }
}
