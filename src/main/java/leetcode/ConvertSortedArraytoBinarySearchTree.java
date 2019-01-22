package leetcode;

/**
 * 将数组转换成平衡二叉树
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/22
 */
public class ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildSortedBST(nums , 0 , nums.length - 1);
    }

    /**
     * 构造排序二叉树
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode buildSortedBST(int[] nums , int start , int end){
        if(start == end){
            return new TreeNode(nums[start]);
        }
        if(start > end){
            return null;
        }

        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildSortedBST(nums , start , middle - 1);
        root.right = buildSortedBST(nums , middle + 1 , end);
        return root;
    }
}
