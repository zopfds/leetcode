package leetcode;

import leetcode.util.ListNode;

import java.util.List;

/**
 * 删除倒数的链表
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class DeleteLastNum {

    private static int index = 0;

    /**
     * 删除倒数的第几个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            index = 0;
            return null;
        }else{
            ListNode next = removeNthFromEnd(head.next , n);
            if(++index == n){
                return head.next;
            }
            head.next = next;
            return head;
        }
    }

    /**
     * 删除倒数的第几个节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode start = head,end = head;
        for(int i = 0 ; i < n ;i ++ ){
            end = end.next;
        }

        if(end == null){
            return head.next;
        }
        while(end.next != null){
            end = end.next;
            start = start.next;
        }
        start.next = start.next.next;
        return head;
    }


    public static void main(String[] args){
        ListNode<Integer> list = new ListNode<>(1);
        ListNode<Integer> list1 = new ListNode<>(2);
        ListNode<Integer> list2 = new ListNode<>(3);
        ListNode<Integer> list3 = new ListNode<>(4);
        ListNode<Integer> list4 = new ListNode<>(5);
        list.next = list1;
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;

        ListNode result = removeNthFromEnd2(list , 2);
    }
}
