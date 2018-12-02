package leetcode;

public class ReverseWords {
    private static class ListNode<T> {
        public T val;
        public ListNode next;
        public ListNode(T x) { val = x; }
    }

    public String reverseWords(String s) {
        if(s.length() == 0){
            return "";
        }

        ListNode<String> start = new ListNode<>("");

        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < s.length() ; i ++){
            if(' ' == s.charAt(i)){
                ListNode<String> node = new ListNode<>(sb.toString());
                node.next = start;
                start = node;
                sb.setLength(0);

                
                continue;
            }

            sb.append(s.charAt(i));
        }

        ListNode<String> node = new ListNode<>(sb.toString());
        node.next = start;
        start = node;
        sb.setLength(0);

        for(;start.next != null; start = start.next){
            sb.append(start.val);
            sb.append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args){
        ReverseWords reverseWords = new ReverseWords();

        System.out.println(reverseWords.reverseWords("the sky is blue"));
    }
}
