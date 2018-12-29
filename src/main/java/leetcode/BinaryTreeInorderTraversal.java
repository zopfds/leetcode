package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中序便利
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/28
 */
public class BinaryTreeInorderTraversal {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode thisNode = root;
        stack.push(thisNode);
        thisNode = thisNode.left;
        while(thisNode != null){
            stack.push(thisNode);
            thisNode = thisNode.left;
        }

        while(!stack.isEmpty()){
            thisNode = stack.pop();
            if(thisNode != null) {
                result.add(thisNode.val);
                thisNode = thisNode.right;
            }
            while(thisNode!= null){
                stack.push(thisNode);
                thisNode = thisNode.left;
            }
        }
        return result;
    }
}
