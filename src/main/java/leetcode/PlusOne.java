package leetcode;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int jin = 1 , j = digits.length - 1;
        while(j >= 0){
            if(jin == 1){
                if(digits[j] == 9){
                    result[j + 1] = 0;
                }else{
                    result[j + 1] = digits[j] + 1;
                    jin = 0;
                }
            }else{
                result[j + 1] = digits[j];
            }
            j--;
        }

        if(jin == 1){
            result[0] = 1;
        }else{
            System.arraycopy(result , 1 , result , 0 , digits.length);
        }
        return result;
    }

    public static void main(String[] args){
        int[] test ={1,2,3};
        plusOne(test);
    }
}
