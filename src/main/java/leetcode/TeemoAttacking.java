package leetcode;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/15
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int start = 0 , count = 0 , end = timeSeries[0] + duration;
        for(int i = 1 ; i < timeSeries.length; i ++){
            if(end < timeSeries[i]){
                count += (end - timeSeries[start]);
                start = i;
            }
            end = timeSeries[i] + duration;
        }
        return count + end - timeSeries[start];
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        int[] test = new int[]{1,4};
        System.out.println(new TeemoAttacking().findPoisonedDuration(test , 2));
    }
}
