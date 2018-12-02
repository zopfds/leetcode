package leetcode;

import leetcode.util.NormalSort;
import leetcode.util.Println;
import leetcode.util.Sort;

import java.io.Serializable;
import java.util.HashMap;

public class TwoSum {

    /**
     * 数字实体
     */
    public static final class Num{
        //数组原下标
        private int originIndex;
        //值
        private int value;

        public int getOriginIndex() {
            return originIndex;
        }

        public void setOriginIndex(int originIndex) {
            this.originIndex = originIndex;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Num(int originIndex, int value) {
            this.originIndex = originIndex;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "originIndex=" + originIndex +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * 暴力搜索
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = i + 1 ; j < nums.length ; j ++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }
        return null;
    }

    /**
     * 排序过后搜索
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Num[] list = new Num[nums.length];

        for(int i = 0 ; i < nums.length ; i ++){
            list[i] = new Num(i , nums[i]);
        }
        //快速排序
        NormalSort.quickSortWithNum(list , 0 , list.length - 1);
        int i = 0 , j = list.length - 1;
        while(i < j && list[i].getValue() + list[j].getValue() != target){
            int x = list[i].getValue() + list[j].getValue();
            if(x > target){
                j--;
            }else if(x < target){
                i++;
            }
        }
        return new int[]{list[i].getOriginIndex() , list[j].getOriginIndex()};
    }

    /**
     * 借助hashmap构造的值和下标的映射
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums , int target){
        HashMap<Integer , Integer> hashMap = new HashMap<>(nums.length);
        for(int i = 0 ; i < nums.length ; i ++ ){
            int j = target - nums[i];
            if(hashMap.containsKey(j)){
                return new int[]{i , hashMap.get(j)};
            }
            hashMap.put(nums[i] , i);
        }
        throw new IllegalArgumentException("error input");
    }

    /**
     * 借助数组实现
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum4(int[] nums , int target){
        int[] existNums = new int[Integer.MAX_VALUE];

        for(int i = 0 ; i < nums.length ; i ++){
            int j = target - nums[i];
            if(existNums[j] != 0){
                return new int[]{existNums[j] , i};
            }
            existNums[nums[i]] = i;
        }
        throw new IllegalArgumentException("error input");
    }

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();

        int[] test = {3,2,4,4,3,5,7};

        Println.printlnArray(twoSum.twoSum4(test , 10));
    }
}
