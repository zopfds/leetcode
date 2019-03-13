package leetcode;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import leetcode.util.Println;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * 四数求和
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/3
 */
public class FourSum {

    private static final Random RANDOM = new Random();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> thisSet = new HashSet<>();
        for(int i = 0 ; i < nums.length - 1; i ++ ){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1 ; j < nums.length - 1; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int thisTarget = target - nums[i] - nums[j];
                if(thisTarget > 2 * nums[nums.length - 1] || thisTarget < 2 * nums[j + 1]){
                    continue;
                }
                for(int k = j + 1 ; k < nums.length ; k ++){
                    if(set.contains(thisTarget - nums[k])){
                        thisSet.add(nums[k]);
                    }else{
                        set.add(nums[k]);
                    }
                }
                for(Integer entry : thisSet){
                    result.add(Arrays.asList(nums[i] , nums[j] , entry ,thisTarget - entry));
                }
                thisSet.clear();
                set.clear();
            }
        }
        return result;
    }
    public static void main(String[] args){
//        int[] test = {0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};
//        new FourSum().fourSum(test , 6).forEach(s -> Println.printArrayList(s));

//        HashMap<Integer , Integer> test = new HashMap<>();
//        test.put(null,null);
//        test.put(null,1);
//        test.put(1 , 1);
//        System.out.println(test);

//        IntStream.range(0 , 10).forEach(a -> {
//            new Thread(() -> {
//                IntStream.range(0 , 10).forEach(b -> {
//                    System.out.println(Thread.currentThread().getName() + "获取原因 = " + getReason());
//                });
//            }).start();
//        });

//        System.out.println(Arrays.asList(1,2,3,4,5).stream().filter(a -> a.equals(1)).findAny().orElse(null) != null);

        ConcurrentHashMap<Integer , Integer> test = new ConcurrentHashMap<>();

        IntStream.range(0 , 20).forEach(a -> {
            test.put(a , a);
        });
    }

    private static String getReason(){
        String value = "\t{\"MOP-QH360\":{\"C003\":1,\"C001\":15,\"C002\":1}}";
        JSONObject jsonObject = JSON.parseObject(value, Feature.OrderedField);
        jsonObject = jsonObject.getJSONObject("MOP-QH360");

        List<String> reasons = new ArrayList<>();
        List<Integer> scales = new ArrayList<>();
        int sum = 0;
        for (String key : jsonObject.keySet()) {
            reasons.add(key);
            int val = jsonObject.getIntValue(key);
            sum += Math.max(0, val);
            scales.add(sum);
        }
        int random = RANDOM.nextInt(sum);
        int index = 0;
        for (int i = 0; i < scales.size(); i++) {
            if (random < scales.get(i)) {
                break;
            }
            index++;
        }
        return reasons.get(index);
    }
}
