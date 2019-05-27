package leetcode;

import java.util.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/25
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] preOrders = preorder.split(",");
        if(preorder.length() == 0){
            return false;
        }
        LinkedList<Integer> first = new LinkedList<>(),second = new LinkedList<>();
        first.addFirst(0);
        int nextCount = 1 ,i = 0;
        while(!first.isEmpty() && i < preOrders.length){
            int thisCount = 0;
            while(!first.isEmpty() && i < preOrders.length){
                i = first.removeFirst();
                if(preOrders[i].equals("#")){
                    thisCount++;
                }
            }
            nextCount = nextCount * 2 - thisCount * 2;
            int j = ++i + nextCount - 1;
            if(j >= preOrders.length){
                return false;
            }
            for(; i <= j ; i ++){
                second.addLast(i);
            }
            first = second;
            second = new LinkedList<>();
        }
        return first.isEmpty() && i == preOrders.length - 1;
    }
    public static void main(String[] args){
        System.out.println(new VerifyPreorderSerializationofaBinaryTree().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
