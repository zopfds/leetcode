package leetcode;


/**
 * 合并两个有序链表
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class MergeTwoSortedLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * 合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1) , tail = result;
        while(l1 != null && l2 != null){
            while(l1 != null && l2 != null && l1.val <= l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }
            while(l1 != null && l2 != null && l2.val <= l1.val){
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }

        if(l1 != null){
            tail.next = l1;
        }else if(l2 != null){
            tail.next = l2;
        }
        return result.next;
    }
    public static void main(String[] args){
        ListNode list = new ListNode(1);
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(4);
        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(6);
        list.next = list2;
        list2.next = list4;
        list1.next = list3;
        list3.next = list5;

        ListNode result = mergeTwoLists(list , list1);

    }
}
