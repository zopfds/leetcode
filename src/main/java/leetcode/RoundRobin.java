package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RoundRobin {

    private int currentWeight = 0;

    private int currentIndex = -1;

    private List<Integer> wl;

    private int maxWeight;

    private int minWeight;

    private int maxCommonDivisor;

    public RoundRobin(List<Integer> wl) {
        this.wl = wl;
        this.maxWeight = maxValue(wl);
        this.minWeight = minValue(wl);
        this.maxCommonDivisor = maxCommonDivisor(wl);
    }

    public static int maxCommonDivisor(List<Integer> wl){
        if(wl == null || wl.size() == 0){
            return Integer.MIN_VALUE;
        }
        if(wl.size() == 1){
            return wl.get(0);
        }
        int a = maxCommonDivisor(wl.get(0) , wl.get(1));
        if(a == 1){
            return 1;
        }
        for(int i = 2 ; i < wl.size() ; i ++){
            a = maxCommonDivisor(a , wl.get(i));
            if(a == 1){
                return a;
            }
        }
        return a;
    }

    /**
     * 求解最大公约数
     * @param a
     * @param b
     * @return
     */
    private static int maxCommonDivisor(int a , int b){
        if(a == 0){
            return a;
        }else if(a % b == 0){
            return b;
        }else{
            return maxCommonDivisor(b , a % b);
        }
    }

    private static int minValue(List<Integer> wl){
        if(wl == null || wl.size() == 0){
            return Integer.MAX_VALUE;
        }
        int result = wl.get(0);
        return wl.stream().min(Comparator.comparing(Integer::intValue)).get();
    }

    private static int maxValue(List<Integer> wl){
        if(wl == null || wl.size() == 0){
            return Integer.MAX_VALUE;
        }
        int result = wl.get(0);
        return wl.stream().max(Comparator.comparing(Integer::intValue)).get();
    }

    private Integer roundRobingetValue(){
        while(true){
            currentIndex = (currentIndex + 1) % wl.size();
            if(currentIndex == 0){
                currentWeight = currentWeight - maxCommonDivisor;
                if(currentWeight <= 0){
                    currentWeight = maxWeight;
                    if(currentWeight <= 0){
                        return null;
                    }
                }
            }

            if(wl.get(currentIndex) >= currentWeight){
                return wl.get(currentIndex);
            }
        }
    }

    public static void main(String[] args){
        Integer[] testArray = {1, 2, 4, 8};
        List<Integer> testList = Arrays.stream(testArray).collect(Collectors.toList());
        RoundRobin roundRobin = new RoundRobin(testList);
        for(int i = 0 ; i < 15 ; i++){
            System.out.println(roundRobin.roundRobingetValue());
        }
    }


}
