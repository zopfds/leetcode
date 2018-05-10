package leetcode;

import leetcode.util.Println;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/5/8
 */
public class MostWater {

    public int maxArea(int[] height) {

        int firstIndex = 0 , secIndex = 0,water = 0;

        if(height[0] >= height[1]){
            firstIndex = 0;
            secIndex = 1;
        }else{
            firstIndex = 1;
            secIndex = 0;
        }

        //找出最大以及次大的数
        for(int i = 2; i < height.length;i++){
            if(height[i] >= height[firstIndex]){
                secIndex = firstIndex;
                firstIndex = i;
            }else if(height[i] >= height[secIndex]){
                secIndex = i;
            }
        }


        int leftEnd = secIndex < firstIndex ? secIndex : firstIndex;
        int rightStart = secIndex < firstIndex ? firstIndex : secIndex;
        int result = (rightStart - leftEnd) * height[secIndex];
        if(water > result){
            result = water;
        }

        int leftNext = leftEnd , rightNext = rightStart;
        int middleWater = (rightStart - leftEnd) * height[height[rightStart] > height[leftEnd] ? leftEnd : rightStart];

        while(leftEnd != 0 || rightStart != height.length - 1 || (height[leftEnd] > 0 && height[rightStart] > 0)) {

            if(middleWater > result){
                result = middleWater;
            }

            if(leftEnd > 0) {
                leftNext = maxIndex(height, 0, leftEnd - 1);
            }
            int leftWater = (rightStart - leftNext) * height[height[rightStart] > height[leftNext] ? leftNext : rightStart];

            if(rightStart < height.length - 1) {
                rightNext = maxIndex(height, rightStart + 1, height.length - 1);
            }

            int rightWater = (rightNext - leftEnd) * height[height[rightNext] > height[leftEnd] ? leftEnd : rightNext];

            if(leftWater > rightWater){
                result = leftWater;
                leftEnd = leftNext;
                middleWater = leftWater;
            }else{
                result = rightWater;
                rightStart = rightNext;
                middleWater = rightWater;
            }
        }

        return result;
    }

    public int maxIndex(int[] height , int start , int end){
        int max = height[start];
        int result = start;
        for(;start <= end ; start++){
            if(height[start] > max){
                max = height[start];
                result = start;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] test = {1,2,4,3};
        System.out.println(new MostWater().maxArea(test));
    }
}
