package leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] result = new char[Math.max(a.length() , b.length()) + 1];
        int i = a.length() - 1 , j = b.length() - 1 , jin = 0 , count = result.length - 1;
        while(i >= 0 && j >= 0){
            if(jin == 0){
                if(a.charAt(i) == '0' || b.charAt(j) == '0'){
                    if(a.charAt(i) == '0' && b.charAt(j) == '0'){
                        result[count] = '0';
                    }else{
                        result[count] = '1';
                    }
                    jin = 0;
                }else{
                    result[count] = '0';
                    jin = 1;
                }
            }else{
                if(a.charAt(i) == '1' || b.charAt(j) == '1'){
                    if(a.charAt(i) == '1' && b.charAt(j) == '1'){
                        result[count] = '1';
                    }else{
                        result[count] = '0';
                    }
                    jin = 1;
                }else{
                    result[count] = '1';
                    jin = 0;
                }
            }
            i--;
            j--;
            count--;
        }

        while(i >= 0){
            if(a.charAt(i) == '1' && jin == 1){
                result[count] = '0';
            }else{
                if(jin == 0){
                    result[count] = a.charAt(i);
                }else{
                    result[count] = '1';
                    jin = 0;
                }
            }
            i--;
            count--;
        }

        while(j >= 0){
            if(b.charAt(j) == '1' && jin == 1){
                result[count] = '0';
            }else{
                if(jin == 0){
                    result[count] = b.charAt(j);
                }else{
                    result[count] = '1';
                    jin = 0;
                }
            }
            j--;
            count--;
        }

        if(jin == 1){
            result[count] = '1';
        }else{
            result[count] = '0';
        }

        return result[0] == '1' ? new String(result) : new String(result , 1 , result.length - 1);
    }

    public static void main(String[] args){
        String test1 = "111";
        String test2 = "111";
        System.out.println(new AddBinary().addBinary(test1 , test2));
    }
}
