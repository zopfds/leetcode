package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2019/4/29
 */
public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        String[] stack = new String[logs.size()];
        int top = -1 , i = 0 , consumeTime = 0;
        while(i < logs.size()){
            while(i < logs.size()){
                if(top == -1){
                    stack[++top] = logs.get(i++);
                }else{
                    String[] topS = stack[top].split(":");
                    String[] is = logs.get(i).split(":");
                    if(!topS[0].equals(is[0]) || topS[1].equals(is[1])){
                        stack[++top] = logs.get(i++);
                    }else{
                        break;
                    }
                }
            }
            if(i < logs.size()){
                String[] topS = stack[top--].split(":");
                String[] is = logs.get(i++).split(":");
                if(topS[1].equals("start") && is[1].equals("end")){
                    int thisConsumeTime = Integer.parseInt(is[2]) - Integer.parseInt(topS[2]) + 1;
                    result[Integer.parseInt(topS[0])] += thisConsumeTime - consumeTime;
                    consumeTime += thisConsumeTime;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<String> test = Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
        System.out.println(JSON.toJSONString(new ExclusiveTimeofFunctions().exclusiveTime(1 , test)));
    }
}
