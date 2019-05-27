package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * 旋转数组
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/5/22
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0){
            return;
        }

        int max = nums.length % k == 0 ? k : 1;
        for(int i = 0 ; i < max ; i ++){
            rotate(nums , i , i ,k , 0);
        }
    }

    private void rotate(int[] nums , int firstStart , int start , int k , int count){
        if(start == firstStart && count > 0){
            return;
        }

        int next = (start + k) % nums.length;
        if(firstStart == next){
            nums[next] = nums[start];
            return;
        }else{
            int tmp = nums[start];
            rotate(nums , firstStart , next , k , count + 1);
            nums[next] = tmp;
        }
    }

    public static void main(String[] args){
        int[] test = {1,2,3,4,5,6};
        new RotateArray().rotate(test , 4);
        System.out.println(JSON.toJSONString(test));

        int a = 1;  //1
        a = a + 1;  //2
        int b = 0;  //3
    }
}
