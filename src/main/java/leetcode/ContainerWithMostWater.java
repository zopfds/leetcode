package leetcode;

import java.util.ArrayList;

/**
 * 盛水最多的容器
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if(height.length == 2){
            return height[0] > height[1] ? height[1] : height[0];
        }
        int result = 0;
        int maxIndex = maxIndex(height , 0 , height.length - 1);
        ArrayList<Integer> leftIndexs = new ArrayList<Integer>(maxIndex);
        ArrayList<Integer> rightIndexs = new ArrayList<Integer>(height.length - 1 - maxIndex);
        if(maxIndex != 0){
            int leftIndex = maxIndex;
            while(leftIndex != 0){
                leftIndex = maxIndex(height , 0 , leftIndex - 1);
                leftIndexs.add(leftIndex);
            }
        }
        if(maxIndex != height.length - 1){
            int rightIndex = maxIndex;
            while(rightIndex != height.length - 1){
                rightIndex = maxIndex(height , height.length - 1 , rightIndex + 1);
                rightIndexs.add(rightIndex);
            }
        }

        for(int i = 0 ; i < leftIndexs.size() ; i ++){
            int min = height[leftIndexs.get(i)] > height[maxIndex] ? height[maxIndex] : height[leftIndexs.get(i)];
            int thisMax = min * (maxIndex - leftIndexs.get(i));
            if(thisMax > result){
                result = thisMax;
            }
            for(int j = 0 ; j < rightIndexs.size() ; j ++){
                min = height[leftIndexs.get(i)] > height[rightIndexs.get(j)] ?  height[rightIndexs.get(j)]:height[leftIndexs.get(i)];
                thisMax = min * (rightIndexs.get(j) - leftIndexs.get(i));
                if(thisMax > result){
                    result = thisMax;
                }
            }
        }

        for(int i = 0 ; i < rightIndexs.size() ; i ++){
            int min = height[rightIndexs.get(i)] > height[maxIndex] ? height[maxIndex] : height[rightIndexs.get(i)];
            int thisMax = min * (rightIndexs.get(i) - maxIndex);
            if(thisMax > result){
                result = thisMax;
            }
        }

        return result;
    }

    public static int maxIndex(int[] height , int fromIndex , int toIndex){
        if(fromIndex == toIndex){
            return fromIndex;
        }
        int max = height[fromIndex];
        int maxIndex = fromIndex;
        boolean incr = fromIndex > toIndex ? false : true;
        while(fromIndex != toIndex){
            if(height[fromIndex] > max){
                max = height[fromIndex];
                maxIndex = fromIndex;
            }
            if(incr){
                fromIndex++;
            }else{
                fromIndex--;
            }
        }
        return height[fromIndex] > max ? fromIndex : maxIndex;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        int[] test = {1,2,4,3};
        System.out.println(maxArea(test));
    }
}
