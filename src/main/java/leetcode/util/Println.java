package leetcode.util;

import java.util.List;

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

    public static void printArray(int[] arrgs){
        if(arrgs == null){
            return;
        }

        for(int i = 0 ; i < arrgs.length ; i ++ ){
            System.out.print(arrgs[i]);
            if(i != arrgs.length - 1){
                System.out.print(",");
            }else{
                System.out.println("\n");
            }
        }
    }

    public static void printArray(char[] arrgs){
        if(arrgs == null){
            return;
        }

        for(int i = 0 ; i < arrgs.length ; i ++ ){
            System.out.print(arrgs[i]);
            if(i != arrgs.length - 1){
                System.out.print(",");
            }else{
                System.out.println("\n");
            }
        }
    }

    public static void printArrayList(List<Integer> list){
        if(list == null || list.size() == 0){
            return;
        }

        for(int i = 0 ; i < list.size() ; i ++ ){
            System.out.print(list.get(i));
            if(i != list.size() - 1){
                System.out.print(",");
            }else{
                System.out.println("");
            }
        }
    }



    public static void printlnList(ListNode node){

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
