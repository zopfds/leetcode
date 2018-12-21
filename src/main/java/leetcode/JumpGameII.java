package leetcode;

import java.util.*;

/**
 * 跳跃游戏
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/13
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        if(nums.length == 2){
            return 1;
        }

        return jumpNext(nums , 0 , 0);
    }

    public static int jumpNext(int[] nums , int step , int start){
        if(start >= nums.length - 1){
            return step;
        }

        if(nums[start] + start >= nums.length - 1){
            return step + 1;
        }

        int min = Integer.MAX_VALUE;
        for(int j = 1 ; j <= nums[start] ; j ++ ){
            int thisMinStep = jumpNext(nums , step + 1 , start + j);
            if(thisMinStep < min){
                min = thisMinStep;
            }
        }
        return min;
    }

    public static int bestJump(int[] nums){
        int current = 0 ,max = 0,step = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(i > current){
                current = max;
                step ++;
            }
            max = Math.max(max , i + nums[i]);
        }
        return step;
    }

    public static int jump1(int[] nums) {
        int cont=0;
        int n=nums.length;
        int i=0;
        int max=0;
        while (max<n-1){
            cont++;
            int a=max;
            for (;i<=a;i++){
                max=Math.max(max,i+nums[i]);
            }
        }
        return cont++;
    }

    public static void main(String[] args){
//        int[] test = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        int[] test1 = {1,2,3,0,0,0,0,0};
//        System.out.println(jump(test));
        System.out.println(jump1(test1));
    }
}
