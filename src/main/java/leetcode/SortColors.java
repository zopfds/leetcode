package leetcode;

/**
 * 设置颜色
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/26
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0 , one = 0 , two = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] == 0){
                nums[two++] = 2;
                nums[one++] = 1;
                nums[zero++] = 0;
            }else if(nums[i] == 1){
                nums[two++] = 2;
                nums[one++] = 1;
            }else{
                nums[two++] = 2;
            }
        }
        return;
    }

    public static void main(String[] args){

    }
}
