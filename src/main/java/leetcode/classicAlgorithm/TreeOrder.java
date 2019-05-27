package leetcode.classicAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/28
 */
public class TreeOrder {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        if(root ==  null){
            return result;
        }
        stack1.addFirst(root);
        while(!stack1.isEmpty()){
            TreeNode top = stack1.removeFirst();
            stack2.addFirst(top);
            if (top.right != null) {
                stack1.addFirst(top.right);
            }
            if (top.left != null) {
                stack1.addFirst(top.left);
            }
        }
        while(!stack2.isEmpty()){
            result.add(stack2.removeFirst().val);
        }
        return result;
    }


}
