package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/28
 */
public class PopulatingNextRightPointersinEachNodeII {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        connectC(root , null);
    }

    private void connectC(TreeLinkNode root , TreeLinkNode parent){
        if(root == null){
            return;
        }

        TreeLinkNode firstNNull = root;
        while(parent != null){
            if(root == parent.left){
                if(parent.right != null){
                    root.next = parent.right;
                    root = root.next;
                }else{
                    parent = parent.next;
                }
            }else if(root == parent.right){
                parent = parent.next;
            }else{
                if(parent.left == null && parent.right == null){
                    parent = parent.next;
                }else if(parent.left != null){
                    root.next = parent.left;
                    root = root.next;
                }else{
                    root.next = parent.right;
                    root = root.next;
                }
            }
        }

        while(firstNNull != null && firstNNull.left == null && firstNNull.right == null){
            firstNNull = firstNNull.next;
        }

        if(firstNNull != null) {
            connectC(firstNNull.left != null ? firstNNull.left : firstNNull.right, firstNNull);
        }
    }

    public static void main(String[] args){
        TreeLinkNode test = new TreeLinkNode(3);
        TreeLinkNode test1 = new TreeLinkNode(9);
        TreeLinkNode test2 = new TreeLinkNode(20);
        TreeLinkNode test3 = new TreeLinkNode(15);
        TreeLinkNode test4 = new TreeLinkNode(7);

        test.left = test1;
        test.right = test2;
        test2.left = test3;
        test2.right = test4;

        new PopulatingNextRightPointersinEachNodeII().connect(test);
    }
}
