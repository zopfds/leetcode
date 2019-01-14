package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成二叉树
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/29
 */
public class UniqueBinarySearchTreesII {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //生成二叉搜索树
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        generateTrees(result , 1 , n);
        return result;
    }

    private List<TreeNode> generateTrees(List<TreeNode> result , int start , int end){
        if(start > end){
            result.add(null);
            return result;
        }

        for(int i = start ; i <= end ; i++){
            List<TreeNode> subLeft = generateTrees(result , start , i - 1);
            List<TreeNode> subRight = generateTrees(result , i + 1 , end);
            for(TreeNode left : subLeft){
                for(TreeNode right : subRight){
                    TreeNode middle = new TreeNode(i);
                    middle.left = left;
                    middle.right = right;
                    result.add(middle);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<TreeNode> result = new UniqueBinarySearchTreesII().generateTrees(5);
        result.forEach(t -> {

        });
    }
}
