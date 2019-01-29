package leetcode;

/**
 * 填充同一节点的兄弟节点
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/1/28
 */
public class PopulatingNextRightPointersinEachNode {
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

        TreeLinkNode oLeft = root;
        while(parent != null){
            if(root == parent.left){
                root.next = parent.right;
            }else if(parent.next != null){
                root.next = parent.next.left;
                parent = parent.next;
            }

            if(root == null){
                break;
            }
            root = root.next;
        }
        connectC(oLeft.left , oLeft);
    }

    public static void main(String[] args){
        TreeLinkNode test = new TreeLinkNode(1);
        TreeLinkNode test1 = new TreeLinkNode(2);
        TreeLinkNode test2 = new TreeLinkNode(3);
        TreeLinkNode test3 = new TreeLinkNode(4);
        TreeLinkNode test4 = new TreeLinkNode(5);
        TreeLinkNode test5 = new TreeLinkNode(6);
        TreeLinkNode test6 = new TreeLinkNode(7);

        test.left = test1;
        test.right = test2;
        test1.left = test3;
        test1.right = test4;
        test2.left = test5;
        test2.right = test6;

        new PopulatingNextRightPointersinEachNode().connect(test);
    }
}
