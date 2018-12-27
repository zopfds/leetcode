package leetcode.classicAlgorithm;

import leetcode.util.Println;

/**
 * 数据结构KMP
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/27
 */
public class KMP {
    public int[] getNext(String model){
        int[] result = new int[model.length()];
        result[0] = -1;
        int i = 0 , j = -1;
        while(i < model.length() - 1) {
            if(j == -1) {
                result[++i] = ++j;
            }else if(model.charAt(i) == model.charAt(j)){
                if(model.charAt(i + 1) == model.charAt(j + 1)){
                    j = result[j];
                }
                result[++i] = result[++j];
            }else{
                j = result[j];
            }
        }
        return result;
    }

    /**
     * 模式串匹配
     * @param testString
     * @param model
     * @return
     */
    public boolean match(String testString , String model){
        int[] next = getNext(model);
        int i = 0 , j = 0;
        while(i < testString.length() && j < model.length()){
            if(j == -1 || testString.charAt(i) == model.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }

       return j >= model.length();
    }

    public static void main(String[] args){
        System.out.println(new KMP().match("abbabcabcd" , "babc"));
    }
}
