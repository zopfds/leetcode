package leetcode;

/**
 * 接雨水
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/13
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < height.length ; i ++){
            if(max < height[i]){
                max = height[i];
            }
        }
        return 0;
    }
}
