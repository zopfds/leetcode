package leetcode;

public class Atoi {
    public int myAtoi(String str) {
        StringBuilder sb = new StringBuilder();

        boolean numStart = false;
        boolean symbol = false;
        boolean neg = false;
        boolean isLeadZero = false;

        for(int i = 0 ; i < str.length() ; i ++){

            char c = str.charAt(i);

            if(c == ' '){
                if(numStart){
                    break;
                }else if(symbol){
                    return 0;
                }
            }else if(c == '-'){
                if(numStart){
                   break;
                }else if(symbol){
                    return 0;
                }else{
                    neg = true;
                    symbol = true;
                }
            }else if(c == '+'){
                if(numStart){
                    break;
                }else if(symbol){
                    return 0;
                }else{
                    symbol = true;
                }
            }else if((c - 48) <= 9 && (c - 48) > 0) {
                sb.append(c);
                numStart = true;
                isLeadZero = false;
            }else if((c - 48) == 0){
                if(numStart && !isLeadZero){
                    sb.append(c);
                }else if(!numStart){
                    isLeadZero = true;
                }

                numStart = true;
            }else if(!numStart){
                return 0;
            }else{
                break;
            }
        }

        String stringResult = sb.toString();

        int i = 1;
        int result = 0;

        if(stringResult.length() > 10){
            if(neg){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }

        for(int j = stringResult.length() - 1 ; j >= 0 ; j--){

            int num = stringResult.charAt(j) - 48;

            if(i >= 1000000000 && num > 2){
                if(neg){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }

            result += num * i;
            if(result < 0) {
                if(neg){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            i = i * 10;
        }


        return neg ? -result : result;
    }

    public static void main(String[] args){
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("-6147483648"));
    }
}
