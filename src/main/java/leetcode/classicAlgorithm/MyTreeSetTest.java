package leetcode.classicAlgorithm;

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/2/16
 */
public class MyTreeSetTest{
    private static final class TreeNode{
        Object value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(Object value, TreeNode left, TreeNode right, TreeNode parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", parent=" + parent +
                    '}';
        }
    }

    public static TreeNode getNext(TreeNode target){
        if(target == null){
            return null;
        }

        TreeNode result = target;
        if(result == null){
            while(result.parent != null && result.parent.left != result){
                result = result.parent;
            }
            return result.parent == null ? result.parent.left == result ? result.parent : null : null;
        }else{
            result = target.right;
            while(result.left != null){
                result = result.left;
            }
            return result;
        }
    }

    public static void main(String[] args){
        Hashtable<Integer , Integer> table  = new Hashtable();
        table.put(null , 1);
    }
}
