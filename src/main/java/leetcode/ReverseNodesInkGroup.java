package leetcode;

/**
 * 反转k个节点的链表
 *
 * startTime:   2018/12/5-14:46
 * endTime:     2018/12/5-19:32
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/5
 */
public class ReverseNodesInkGroup {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 反转k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        return reverseKGroup(head , k , k);
    }

    /**
     * 反转k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int count , int k) {
        if(head.next == null){
            if(count == 1 || count == k){
                return head;
            }else{
                return null;
            }
        }

        ListNode newHead = reverseKGroup(head.next , count == 1 ? k : count - 1 , k);
        //处理最后不满k个节点的情况
        if(newHead == null){
            if(count != k){
                return null;
            }else{
                return head;
            }
        }
        //处理正常满足k个节点的情况
        if(count == 1){
            head.next = newHead;
            return head;
        }else{
            ListNode nextN = head.next.next;
            head.next.next = head;
            head.next = nextN;
            return newHead;
        }
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        ReverseNodesInkGroup reverseNodesInkGroup = new ReverseNodesInkGroup();
        ListNode list = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        list.next = list2;
        list2.next = list3;
        list3.next = list4;
//        reverseNodesInkGroup.reverseKGroup(list , 3);
        reverseNodesInkGroup.reverseKGroup(list , 1 , 1);
    }
}
