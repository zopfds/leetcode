package leetcode;

import java.util.LinkedList;

/**
 * 匹配最长
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/7
 */
public class LongestValidParentheses {

    public static class ListNode {
        MaxLengthInfo val;
        ListNode next;
        ListNode(MaxLengthInfo x) { val = x; }

        public void addAfterThis(ListNode next){
            next.next = this.next;
            this.next = next;
        }
    }

    private static final class MaxLengthInfo{
        int startIndex;
        int endIndex;
        int length;

        public MaxLengthInfo(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.length = endIndex - startIndex + 1;
            this.endIndex = endIndex;
        }
    }

    public int longestValidParentheses(String s) {
        if(s.length() < 2){
            return 0;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        //startIndex记忆最长有效串的开始位置,maxLength记忆最长串的数量以及长度
        ListNode maxLengthInfos = new ListNode(null);
        //每个有效串的长度，开始位置
        int thisMax = 0,thisStart = -1;
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '('){
                if(i != s.length() - 1) {
                    stack.offerFirst(i);
                    if (thisMax == 0) {
                        thisStart = i;
                    }
                }else{
                    int j = i - 1;
                    while(j >= 0 && s.charAt(j) != ')'){
                        j--;
                    }
                    if(j != -1 && thisStart != -1) {
                        maxLengthInfos.addAfterThis(new ListNode(new MaxLengthInfo(thisStart, j)));
                    }
                }
            }else{
                //获取当前匹配的的'('的下标
                Integer posi = stack.pollFirst();
                //当前为'）'但堆栈中不存在'('的时候
                if(posi == null){
                    if(thisStart != -1) {
                        maxLengthInfos.addAfterThis(new ListNode(new MaxLengthInfo(thisStart, i - 1)));
                        thisMax = 0;
                        thisStart = -1;
                    }
                    //堆栈中存在'('
                }else{
                    //如果当前'('的位置小于当前thisStart
                    if(posi < thisStart){
                        thisStart = posi;
                    }
                    thisMax += 2;
                    if(i == s.length() - 1){
                        maxLengthInfos.addAfterThis(new ListNode(new MaxLengthInfo(thisStart , i)));
                    }
                }
            }
        }

        Integer posi = null;
        ListNode p = null;
        //获取当前匹配的的'('的下标
        while((posi = stack.pollFirst()) != null){
            p = maxLengthInfos;
            ListNode q = p.next;
            while(q != null && (posi < q.val.startIndex || posi > q.val.endIndex)){
                p = q;
                q = p.next;
            }
            if(q != null){
                p.next = q.next;
                p.addAfterThis(new ListNode(new MaxLengthInfo(q.val.startIndex , posi - 1)));
                p.addAfterThis(new ListNode(new MaxLengthInfo(posi + 1 , q.val.endIndex)));
                q = p.next;
            }
        }

        p = maxLengthInfos.next;
        int result = p == null ? 0 : p.val.length;
        while(p != null){
            if(p.val.length > result){
                result = p.val.length;
            }
            p = p.next;
        }

        return result;
    }

    public static void main(String[] args){
        LongestValidParentheses test = new LongestValidParentheses();
        String testString ="()(()(((";
        System.out.println(test.longestValidParentheses(testString));
    }
}
