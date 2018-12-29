package leetcode;

import leetcode.util.Println;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/28
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restore(result , "" , s , 0 , 0);
        return result;
    }

    private void restore(List<String> result , String thisString , String s , int start , int count){
        if(count > 3){
            if(start >= s.length()){
                result.add(thisString);
            }
            return;
        }

        int i = 0 , num = 0;
        String thisNum = "";
        while(start + i < s.length() && i < 3){
            thisNum = thisNum + s.charAt(start + i);
            if(Integer.valueOf(thisNum) <= 255){
                thisString = thisString + thisNum;
                if(count < 3){
                    thisString = thisString + '.';
                }
                restore(result , thisString , s , start + i + 1 , count + 1);
                if(count < 3){
                    thisString = thisString.substring(0 , thisString.length() - thisNum.length() - 1);
                }else {
                    thisString = thisString.substring(0 , thisString.length() - thisNum.length());
                }

                if(Integer.valueOf(thisNum) == 0){
                    break;
                }
                i++;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args){
        Println.printStringList(new RestoreIPAddresses().restoreIpAddresses("010010"));
    }
}
