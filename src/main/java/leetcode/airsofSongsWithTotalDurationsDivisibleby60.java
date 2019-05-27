package leetcode;

import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/5/22
 */
public class airsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        Arrays.sort(time);
        int[] timeNum = new int[501];
        for(int i = 0 ; i < time.length ; i ++){
            timeNum[time[i]] = timeNum[time[i]] + 1;
        }
        for(int i = 0 ; i < time.length ; i ++){
            int thisCount = 0;
            if(i != 0 && time[i] == time[i - 1]){
                continue;
            }
            if((time[i] == 30 || time[i] % 60 == 0)&& timeNum[time[i]] > 1){
                thisCount = (timeNum[time[i]] - 1) * timeNum[time[i]] / 2;
            }else {
                for (int j = (time[i] * 2 / 60) * 60 + 60; j <= 960; j = j + 60) {
                    if (j - time[i] > time[time.length - 1]) {
                        break;
                    } else if (j - time[i] >= 0) {
                        thisCount += timeNum[time[i]] * timeNum[j - time[i]];
                    }
                }
            }
            result += thisCount;
        }
        return result;
    }

    public static void main(String[] args){
        int[] time = {60,60,60};
        System.out.println(new airsofSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(time));
    }
}
