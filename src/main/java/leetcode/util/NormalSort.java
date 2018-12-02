package leetcode.util;

import leetcode.TwoSum;

import java.util.Arrays;

/**
 * 常规排序算法实现
 */
public class NormalSort {

    /**
     * 快速排序
     * @param list
     */
    public static void quickSort(int[] list , int start , int end){
        if(start >= end){
            return;
        }
        //选取标志元素
        int index = list[start];
        int i = start, j = end;
        while(i < j){
            while(i < j && list[j] >= index){
                j--;
            }
            if(i >= j){
                break;
            }
            list[i] = list[j];
            while(i < j && list[i] <= index){
                i++;
            }
            if(i >= j){
                break;
            }
            list[j] = list[i];
        }

        list[i] = index;
        quickSort(list , start , i - 1);
        quickSort(list , i + 1 , end);
    }

    /**
     * 快速排序
     * @param list
     */
    public static void quickSortWithNum(TwoSum.Num[] list , int start , int end){
        if(start >= end){
            return;
        }
        //选取标志元素
        TwoSum.Num index = list[start];
        int i = start, j = end;
        while(i < j){
            while(i < j && list[j].getValue() >= index.getValue()){
                j--;
            }
            if(i >= j){
                break;
            }
            list[i] = list[j];
            while(i < j && list[i].getValue() <= index.getValue()){
                i++;
            }
            if(i >= j){
                break;
            }
            list[j] = list[i];
        }
        list[i] = index;
        quickSortWithNum(list , start , i - 1);
        quickSortWithNum(list , i + 1 , end);
    }

    public static void main(String[] args){
        int[] testString = new int[]{1,4,3,2,6,8,4,3,8,33};
        quickSort(testString , 0 , testString.length - 1);
        Arrays.stream(testString).forEach(System.out::print);
    }
}
