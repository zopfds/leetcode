package leetcode;

import java.util.Arrays;

public class MostWater2 {

    public int mostWater(int[] area){
        int maxIndex = getMaxIndexBetween(0 , area.length , area);
        return mostWaterBetween(0 , maxIndex , area) + mostWaterBetween(maxIndex , area.length - 1 , area);
    }

    public int mostWaterBetween(int left , int right , int[] list){
        if(left >= right - 1){
            return 0;
        }else{
            int nextMax = getMaxIndexBetween(left + 1 , right , list);

            int thisArea = 0;
            int leftRightMin = list[left] < list[right] ? list[left] : list[right];
            if(list[nextMax] < list[left] && list[nextMax] < list[right]){
                thisArea = (right - left - 1) * (leftRightMin - list[nextMax]);
            }
            return thisArea + mostWaterBetween(left , nextMax , list) + mostWaterBetween(nextMax , right , list);
        }
    }

    public int getMaxIndexBetween(int left , int right , int[] area){
        int result = left;
        for(; left < right ; left ++){
            if(area[left] > area[result]){
                result = left;
            }
        }
        return result;
    }

    public static void main(String[] args){
        MostWater2 mostWater2 = new MostWater2();
        int[] test = new int[]{2,1,3,4,9,5,3,4,2,7,8,9};
        System.out.println(mostWater2.mostWater(test));
    }
}
