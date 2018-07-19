package leetcode;

import leetcode.util.Println;

public class BitCount {
//    public int[] countBits(int num) {
//        if(num == 0){
//            return new int[1];
//        }
//
//        int[] result = new int[num + 1];
//        result[1] = 1;
//        int i = 1 ;
//        while(i <= (num >> 1)){
//
//            if(is2log(i)){
//                result[2*i] = 1;
//            }else{
//                result[2*i] = result[i];
//            }
//0
//            int middle = (2 * i + 1);
//
//            if(middle < result.length) {
//                if (is2log(i + 1)) {
//                    result[middle] = result[i] + result[i + 1];
//                } else {
//                    result[middle] = result[i] == result[i + 1] ? result[i] + 1 : (
//                            result[i] > result[i + 1] ? result[i] : result[i + 1]);
//                }
//            }
//
//            i++;
//        }
//
//        return result;
//    }
//
//    /**
//     * 是否为2的对数
//     * @param i
//     * @return
//     */
//    private boolean is2log(int i) {
//        String dui = String.valueOf(Math.log(i) / Math.log(2));
//
//        int index = dui.indexOf('.');
//
//        String xiaoshu = dui.substring(index + 1 , dui.length());
//
//        return Long.valueOf(xiaoshu) == 0L;
//    }
//
//    public static void main(String[] args){
//
//
//        BitCount bitCount = new BitCount();
//
//        boolean reuslt = bitCount.is2log(11);
//
//        Println.printlnArray(bitCount.countBits(2));
//    }
}
