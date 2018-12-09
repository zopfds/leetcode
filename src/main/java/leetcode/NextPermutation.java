package leetcode;

/**
 * 下一个排列
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/7
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int k;
        if(nums.length <= 1){
            return;
        }else if(nums.length == 2){
            k = nums[0];
            nums[0] = nums[1];
            nums[1] = k;
        }

        for(int i = nums.length - 2 ; i >= 1 ; i--){
            // 第一个大于第二个 423 ， 432 ， 433
            if(nums[i - 1] > nums[i]){
                //第二个大于第三个 432
                if(nums[i] > nums[i + 1] || nums[i] == nums[i + 1]){
                    continue;
                    //第二个小于第三个 423,324,323
                }else if(nums[i] < nums[i + 1]){
                    k = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = k;
                    return;
                }
                //第一个小于第二个 234，243，233, 342,232
            }else if(nums[i - 1]< nums[i]){
                //第二个大于第三个 243 342
                if(nums[i] > nums[i + 1]){
                    //第一个小于第三个 243
                    if(nums[i-1] <  nums[i+1]){
                        k = nums[i + 1];
                        nums[i + 1] = nums[i];
                        nums[i] = nums[i - 1];
                        nums[i - 1] = k;
                        return;
                        //第一个大于第三个 342
                    }else if(nums[i-1] > nums[i+1] || nums[i-1] == nums[i+1]){
                        k = nums[i-1];
                        nums[i-1] = nums[i];
                        nums[i] = nums[i+1];
                        nums[i+1] = k;
                        return;
                    }
                    //第二个小于第三个 234
                }else if(nums[i] < nums[i + 1]){
                    k = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = k;
                    return;
                    //第二个等于第三个 233
                }else{
                    k =  nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = k;
                    return;
                }
                //第一个等于第二个 223 ， 221 , 222
            }else{
                //第二个大于第三个或第二个等于第三个,221,222
                if(nums[i] == nums[i + 1] || nums[i] > nums[i + 1]){
                    continue;
                    //第二个小于第三个223
                }else{
                    k = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = k;
                    return;
                }
            }
        }

        for(int i = 0 ; i < (nums.length - 1) / 2 ; i ++){
            k = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 -i] = k;
        }

        return;
    }

    public boolean reverse(int[] nums , int i){
        if(i <= nums.length - 2 && reverse(nums , i)){
            return true;
        }

        if(nums[i] < nums[i + 1]){
            
        }

        return reverse(nums , i + 1);
    }
}
