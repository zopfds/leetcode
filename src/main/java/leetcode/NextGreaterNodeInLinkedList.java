package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/25
 */
public class NextGreaterNodeInLinkedList {
    static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public int[] nextLargerNodes(ListNode head) {
        ListNode[] stack = new ListNode[10000];
        int[] indexStack = new int[10000];
        int[] result = new int[10000];
        int top = 0;
        if(head == null){
            return new int[0];
        }
        stack[top] = head;
        head = head.next;
        int index = 1 , count = 1;
        while(head != null){
            ListNode next = head.next;
            while(top != -1 && stack[top].val < head.val){
                result[indexStack[top]] = head.val;
                top--;
            }
            stack[++top] = head;
            indexStack[top] = count++;
            head = next;
        }
        int[] realResult = new int[count];
        for(int i = 0 ; i < realResult.length ; i ++){
            realResult[i] = result[i];
        }
        return realResult;
    }

    public static void main(String[] args){
          ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        System.out.println(JSON.toJSONString(new NextGreaterNodeInLinkedList().nextLargerNodes(node1)));
    }
}
