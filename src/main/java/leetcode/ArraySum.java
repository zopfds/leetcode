package leetcode;


import leetcode.util.ListNode;
import leetcode.util.Println;

/**
 * leetcode 两数之和
 */
public class ArraySum {


    public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode result = new ListNode(-1);

        ListNode realResult = result;

        int plus = 0;

        while(l1 != null && l2 != null){

            int sum = l1.val + l2.val + plus;

            plus = sum >= 10 ? 1 : 0;

            result.next = new ListNode(sum >= 10 ? sum - 10 : sum);

            l1 = l1.next;

            l2 = l2.next;

            result = result.next;
        }

        while(l1 != null){
            int sum = l1.val + plus;

            plus = sum >= 10 ? 1 : 0;

            result.next = new ListNode(sum >= 10 ? sum - 10 : sum);

            l1 = l1.next;

            result = result.next;
        }

        while(l2 != null){

            int sum = l2.val + plus;

            plus = sum >= 10 ? 1 : 0;

            result.next = new ListNode(sum >= 10 ? sum - 10 : sum);

            l2 = l2.next;

            result = result.next;
        }

        if(plus == 1){
            result.next = new ListNode(1);
        }

        return realResult.next;
    }

    public ListNode addTwoNumbers2(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode result = new ListNode(0);

        ListNode realResult = result;

        int plus = 0;

        int val = 0;

       while(l1 != null || l2 != null || plus == 0){

           val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + plus;

           plus = val > 9 ? 0 : 1;

           result.next = new ListNode(plus == 1 ? val : val - 10);

           result = result.next;

           l1 = l1 == null ? null : l1.next;

           l2 = l2 == null ? null : l2.next;
       }

       return realResult.next;
    }

    public static void main(String[] args){
        ArraySum arraySum = new ArraySum();

//        ListNode list1 = new ListNode(9);
//        ListNode node2 = new ListNode(9);
//        list1.next = node2;
//        ListNode node3 = new ListNode(9);
//        node2.next = node3;
//        ListNode node4 = new ListNode(9);
//        node3.next = node4;
//        ListNode node5 = new ListNode(9);
//        node4.next = node5;
//
//        ListNode list2 = new ListNode(9);
//        ListNode node6 = new ListNode(9);
//        list2.next = node6;
//        ListNode node7 = new ListNode(9);
//        node6.next = node7;
//        ListNode node8 = new ListNode(9);
//        node7.next = node8;

        ListNode<Integer> list1 = new ListNode(0);

        ListNode<Integer> list2 = new ListNode(0);

        Println.printlnList(arraySum.addTwoNumbers2(list1 , list2));
    }
}
