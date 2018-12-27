package leetcode;

/**
 * 删除链表中重复的节点
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/27
 */
public class RemoveDuplicatesfromSortedListII {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode( - 1);
        newHead.next = head;
        ListNode dupHead = newHead , dupTail = newHead.next;
        int count = 0;
        while(dupTail.next != null){
            if(dupHead.next.val == dupTail.next.val){
                dupTail = dupTail.next;
                count++;
            }else{
                if(count != 0) {
                    dupHead.next = dupTail.next;
                }else{
                    dupHead = dupTail;
                    dupTail = dupTail.next;
                }
                count = 0;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(4);
        ListNode head7 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;

        ListNode result = new RemoveDuplicatesfromSortedListII().deleteDuplicates(head);
        while(result != null){
            System.out.print(result.val);
            System.out.print("->");
        }
    }
}
