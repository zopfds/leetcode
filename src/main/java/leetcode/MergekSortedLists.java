package leetcode;

/**
 * 合并k个有序链表
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/4
 */
public class MergekSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        //获取链表是否为空映射数组
        boolean[] emptyIndexMap = new boolean[lists.length];
        int emptyCount = 0;
        for(int i = 0 ; i < lists.length ; i ++){
            if(lists[i] == null){
                emptyIndexMap[i] = true;
                emptyCount++;
            }
        }

        ListNode result = new ListNode(-1) , tail = result;

        while(emptyCount < lists.length){
            int minIndex = firstNotEmptyIndexFromStart(emptyIndexMap , 0);
            if(minIndex >= lists.length){
                break;
            }
            int thisIndex = minIndex;
            while(thisIndex < emptyIndexMap.length){
                if(lists[thisIndex].val < lists[minIndex].val){
                    minIndex = thisIndex;
                }
                thisIndex = firstNotEmptyIndexFromStart(emptyIndexMap , thisIndex + 1);
            }

            tail.next = lists[minIndex];
            if(lists[minIndex].next == null){
                emptyIndexMap[minIndex] = true;
                emptyCount++;
            }
            lists[minIndex] = lists[minIndex].next;
            tail = tail.next;
            tail.next = null;
        }

        return result.next;
    }

    public static int firstNotEmptyIndexFromStart(boolean[] emptyIndexMap , int start){
        for(int i = start ; i < emptyIndexMap.length ; i ++){
            if(!emptyIndexMap[i]){
                return i;
            }
        }
        return emptyIndexMap.length;
    }

    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        ListNode list12 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list42 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        ListNode list6 = new ListNode(6);
        list1.next = list4;
        list4.next = list5;
        list12.next = list3;
        list3.next = list42;
        list2.next = list6;
        ListNode[] test = new ListNode[3];
        test[0] = list1;
        test[1] = list12;
        test[2] = list2;

        mergeKLists(test);
    }
}
