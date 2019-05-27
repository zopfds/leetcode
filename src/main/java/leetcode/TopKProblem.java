package leetcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/3
 */
public class TopKProblem {
    public int findKthLargest(int[] nums, int k) {
        int[] buf = new int[k * 2];
        int bufSize = 0 , index = 0;
        int minHold = nums[0];
        for(;index < k ; index++){
            buf[bufSize++] = nums[index];
            minHold = Math.min(minHold , nums[index]);
        }

        for(; index < nums.length ; index ++){
            if(nums[index] <= minHold){
                continue;
            }

            buf[bufSize++] = nums[index];
            if(bufSize == 2 * k){
                if(k == 1){
                    if(buf[0] < buf[1]){
                        int flag = buf[1];
                        buf[1] = buf[0];
                        buf[0] = flag;
                    }
                    bufSize = 1;
                }else {
                    bufSize = partion(buf, 0, bufSize - 1, k) + 1;
                }
            }
        }

        Arrays.sort(buf , 0 , bufSize);
        return buf[bufSize - k];
    }

    /**
     * 快排思想
     */
    public int partion(int[] buf , int left , int right , int k){
        int flag = buf[left] , lastLeft = left , lastRight = right;
        if(buf[right] > flag){
            buf[left] = buf[right];
            buf[right] = flag;
            flag = buf[left];
        }
        while(left < right){
            while(left < right && buf[right] < flag){
                right --;
            }
            if(left < right){
                buf[left++] = buf[right];
            }
            while(left < right && buf[left] > flag){
                left ++;
            }
            if(left < right){
                buf[right --] = buf[left];
            }
        }
        buf[left] = flag;
        if(left < k - 1 + lastLeft){
            return partion(buf , left + 1 , lastRight , k - 1 - left);
        }else{
            return left;
        }

    }

    public static void main(String[] args){
        Stream<String> fs = null;
        try {
            fs = Files.lines(Paths.get("/Users/jianbopan/Desktop/num.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        final StringBuffer sb = new StringBuffer();
        fs.forEach(a -> sb.append(a));
        List<Integer> integers = Arrays.stream(sb.toString().split(",")).map(a -> Integer.valueOf(a)).collect(Collectors.toList());
        int[] test = new int[integers.size()];
        for(int i = 0 ; i < integers.size() ; i ++){
            test[i++] = integers.get(i);
        }
        System.out.println(new TopKProblem().findKthLargest(test , 918));
    }
}
