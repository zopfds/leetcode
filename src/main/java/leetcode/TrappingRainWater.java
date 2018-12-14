package leetcode;

/**
 * 接雨水
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/13
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        if(height.length < 3){
            return 0;
        }
        int maxIndex = getMaxIndexBetween(0 , height.length - 1 , height);
        int leftEnd = maxIndex , leftStart = 0 , leftMiddle = 0;
        int result = 0;
        while(leftStart < leftEnd){
            leftMiddle = getMaxIndexBetween(leftStart , leftEnd - 1 , height);
            result += (leftEnd - leftMiddle - 1) * height[leftMiddle];
            result -= getInvalidAreaBetween(leftMiddle + 1 , leftEnd - 1 , height);
            leftStart = 0;
            leftEnd = leftMiddle;
        }

        int rightEnd = maxIndex , rightStart = height.length - 1 , rightMiddle = height.length - 1;
        while(rightStart > rightEnd){
            rightMiddle = getMaxIndexBetween(rightStart , rightEnd + 1 , height);
            result += (rightMiddle - rightEnd - 1) * height[rightMiddle];
            result -= getInvalidAreaBetween(rightEnd + 1 , rightMiddle - 1 , height);
            rightStart = height.length - 1;
            rightEnd = rightMiddle;
        }

        return result;
    }

    public static int getMaxIndexBetween(int start , int end , int[] height){
        if(start == end){
            return start;
        }
        int max = height[start];
        int maxIndex = start;
        boolean order = start > end ? false : true;
        while(start != end){
            if(height[start] > max){
                max = height[start];
                maxIndex = start;
            }
            start = order ? start + 1 : start - 1;
        }
        return height[end] > max ? end : maxIndex;
    }

    public static int getInvalidAreaBetween(int start , int end , int[] height){
        if(start > end){
            return 0;
        }
        if(start == end){
            return height[start];
        }

        int result = 0;
        for(; start <= end ; start++){
            result += height[start];
        }
        return result;
    }

    public static void main(String[] args){
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(test));
    }
}
