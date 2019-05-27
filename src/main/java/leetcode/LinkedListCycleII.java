package leetcode;

/**
 * 链表换
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/12
 */
public class LinkedListCycleII {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode detectCycle(ListNode head) {
            ListNode fast = head , slow = head;
            do{
                fast = fast.next.next;
                slow = slow.next;
            }while(fast != null && slow != null && fast != slow);
            if(slow != fast){
                return new ListNode(-1);
            }
            fast = head;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3) , node2 = new ListNode(2) , node3 = new ListNode(0), node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(new LinkedListCycleII().detectCycle(node1));
    }
}
