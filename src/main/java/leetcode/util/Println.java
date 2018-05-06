package leetcode.util;

/**
 * leetCode打印工具类
 */
public class Println {

    public static void printlnArray(int[] array){

        if(array == null){
            return;
        }

        for(int i = 0 ; i < array.length ; i ++ ){
            System.out.println(array[i]);
        }
    }

    public static void printlnList(ListNode node){

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
