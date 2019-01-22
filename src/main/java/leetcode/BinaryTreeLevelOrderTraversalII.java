package leetcode;

import leetcode.util.Println;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/22
 */
public class BinaryTreeLevelOrderTraversalII {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> thisList = new ArrayList<>();
        thisList.add(root);
        levelOrderBottomF(thisList , result);
        return result;
    }

    private void levelOrderBottomF(List<TreeNode> thisList , List<List<Integer>> result){
        if(thisList == null || thisList.size() == 0){
            return;
        }
        List<TreeNode> nextList = new ArrayList<>();
        for(int i = 0 ; i < thisList.size() ; i ++){
            TreeNode thisNode = thisList.get(i);
            if(thisNode != null){
                if(thisNode.left != null){
                    nextList.add(thisNode.left);
                }
                if(thisNode.right != null){
                    nextList.add(thisNode.right);
                }
            }
        }
        levelOrderBottomF(nextList , result);
        List<Integer> thisResult = new ArrayList<>();
        for(int i = 0 ; i < thisList.size() ; i ++){
            thisResult.add(thisList.get(i).val);
        }
        if(thisList != null && thisList.size() != 0) {
            result.add(thisResult);
        }
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
        List<List<Integer>> result = new BinaryTreeLevelOrderTraversalII().levelOrderBottom(root);

        for(int i = 0 ; i < result.size() ; i ++){
            Println.printArrayList(result.get(i));
        }
    }
}
