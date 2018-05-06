package leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        char[] xChars = Integer.valueOf(x).toString().toCharArray();

        char temp;

        int start = x < 0 ? 1 : 0,length = xChars.length - 1 ,result = 0;

        while(start < length){

            if(xChars[start] != xChars[length]) {

                temp = xChars[start];

                xChars[start] = xChars[length];

                xChars[length] = temp;

            }

            start++;

            length--;

        }

        try{
            result = Integer.parseInt(String.valueOf(xChars));
        }catch(Exception e){
            result = 0;
        }

        return result;
    }
}
