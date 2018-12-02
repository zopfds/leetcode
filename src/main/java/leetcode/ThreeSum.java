package leetcode;
import leetcode.util.Println;

import java.util.*;

public class ThreeSum {
    /**
     * 双重循环借助hashSet去重搜索
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums , 0 , nums.length);
        List<List<Integer>> result  = new ArrayList<>();
        for(int i = 0; i < nums.length - 1 ; i ++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            HashSet<Integer> set = new HashSet<>();
            for(int j = i + 1; j < nums.length ; j++){
                //这里必须 nums[j-2] = nums[j-1] = nums[j]才跳过本次循环，不然会排除掉{0,0,0}的情况
                //其实也可以单独将{0,0,0}情况独立判断，这里只是简单的去掉连续3个数重复的情况，hashSet才能最终保障结果集不重复
                if(j > i + 2 && nums[j] == nums[j - 1] && nums[j - 2] == nums[j - 1]){
                    continue;
                }
                //求出第三个数的值
                int k = -(nums[i] + nums[j]);
                //这里要移除掉第三个数的值，防止后面的重复扫描
                if(set.remove(k)){
                    result.add(Arrays.asList(nums[i] , nums[j] , k));
                    //
                }else{
                    set.add(nums[j]);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        HashSet<Integer> repeatSet = new HashSet<>();
        HashMap<Integer , HashMap<Integer , Integer>> resultMap = new HashMap<>();
        for(int i = 0; i < nums.length - 1 ; i ++){
            //最外层去重
            if(!repeatSet.contains(nums[i])) {
                //里层去重
                HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
                //
                for (int j = i + 1; j < nums.length; j++) {
                    HashSet<Integer> mSet = map.get(nums[j]);
                    if (mSet != null && mSet.size() != 0) {
                        Iterator<Integer> iterator = mSet.iterator();
                        while (iterator.hasNext()) {
                            int next = iterator.next();
                            int max = nums[i];
                            int middle = nums[i];
                            int min = next;
                            if(nums[i] >= next){
                                if(nums[i] <= nums[j]){
                                    max = nums[j];
                                }else if(nums[j] >= next){
                                    middle = nums[j];
                                }else{
                                    middle = next;
                                    min = nums[j];
                                }
                            }else{
                                if(nums[j] <= nums[i]){
                                    max = next;
                                    min = nums[j];
                                }else if(nums[j] >= next){
                                    max = nums[j];
                                    middle = next;
                                    min = nums[i];
                                }else{
                                    max = next;
                                    middle = nums[j];
                                    min = nums[i];
                                }
                            }
                            HashMap<Integer , Integer> middleMap = resultMap.get(max);
                            if(middleMap != null && middleMap.get(middle) != null && min == middleMap.get(middle)){
                                continue;
                            }else{
                                middleMap = middleMap == null ? new HashMap<Integer , Integer>(): middleMap;
                                middleMap.put(middle , min);
                                resultMap.put(max , middleMap);
                            }
                            result.add(Arrays.asList(nums[i], next, nums[j]));
                        }
                        map.remove(nums[j]);
                    } else {
                        mSet = mSet == null ? new HashSet<>() : mSet;
                        mSet.add(nums[j]);
                        map.put(-(nums[i] + nums[j]), mSet);
                    }
                }
                repeatSet.add(nums[i]);
            }
        }
        return result;
    }

    /**
     * leetcode标准范例
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        if (nums.length < 3)
            return Collections.emptyList();
        //以下代码目的在于以一个循环中统计出数组中的最大，最小值，以及等于0，小于0，大于0的数字个数
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        //对于存在3个0的特殊情况，加入结果集
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        //只有大于0或者小于0的数，直接返回
        if (negSize == 0 || posSize == 0)
            return res;
        //这段判断目的在于收缩最大最小值的范围，这里的minValue和maxValue是后面扫描的最大最小值，并不是数组的最大最小值
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        /**
         * 以一层循环扫描上面得到的收缩集的返回，将值映射到数组的下标上，将出现次数映射到map数组的值上
         * 注意：这里以最小值为map数组的基础偏移量0，所以判断值是否存在以map[v - minValue]==0为判断根据，该map数组中的值就是元素在原始数组中出现的次数
         * 得到收缩后去重的正数集，和负数集
         */
        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        //将得到的正数集和负数集排序，这里用的是快排
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        /**
         * 这里以负数集为循环外层，以map数组为判断元素是否存在的根据，加入结果集中
         */
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            //第一个数为负数，则余下两个数必定存在一个正数，并且该正数一定大于或等于该负数的一半，令这个数为minp
            int minp = (-nv) >>> 1;
            //找到数组中存在的大于等于minp的最小的扫描正数集的下标令其为basej
            while (basej < posSize && poses[basej] < minp)
                basej++;
            //从basej开始扫描正数集
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                //定位到第三个数
                int cv = 0 - nv - pv;
                //若第三个数在nv和pv之间
                if (cv >= nv && cv <= pv) {
                    //cv等于nv，说明三个数中两个负数相等，判断nv在map数组上数量是否大于1,也就是原始数组中是否存在两个负数nv
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    //cv等于pv，说明三个数中两个正数相等，判断pv在map数组上数量是否大于1,也就是原始数组中是否存在两个正数pv
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    //否则看第三个数在map数组上是否大于0，大于表示存在，加入结果集
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                //若第三个数比第一个数自身还小，终止本次循环，因为不允许出现重复集合，所以第三个数只能在nv和pv之间
                } else if (cv < nv)
                    break;
            }
        }
        return res;
    }



    /**
     * 获取符合条件的三元组
     * @param args
     */
    public static void main(String[] args){
        int[] test = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> result = threeSum(test);
        result.stream().forEach(list -> Println.printArrayList(list));
    }
}
