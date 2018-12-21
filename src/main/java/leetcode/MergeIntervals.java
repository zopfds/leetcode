package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/19
 */
public class MergeIntervals {
    private static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    /**
     * 合并区间
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2){
            return intervals;
        }
        quickSort(intervals , 0 , intervals.size() - 1);
        int i = 0 , j = 1;
        while(j < intervals.size()){
            if(intervals.get(j).start <= intervals.get(i).end){
                intervals.get(i).end = Math.max(intervals.get(i).end , intervals.get(j++).end);
            }else{
                intervals.set(++i , intervals.get(j++));
            }
        }

        return intervals.subList(0 , i + 1);
    }

    /**
     * 快排
     * @param intervals
     * @param start
     * @param end
     */
    public static void quickSort(List<Interval> intervals , int start , int end){
        if(start >= end){
            return;
        }

        int i = start, j = end;
        Interval k = intervals.get(start);
        while(i < j){
            while(i < j && ((intervals.get(j).start >= k.start) || intervals.get(j).start == k.start && intervals.get(j).end >= k.end)){
                j--;
            }
            if(i >= j){
                break;
            }
            intervals.set(i++ , intervals.get(j));
            while(i < j && (intervals.get(i).start <= k.start || intervals.get(j).start == k.start && intervals.get(i).end <= k.end)){
                i++;
            }
            if(i >= j){
                break;
            }
            intervals.set(j--, intervals.get(i));
        }
        if(i == j){
            intervals.set(i , k);
        }else {
            intervals.set(i - 1, k);
        }
        quickSort(intervals , start , i - 1);
        quickSort(intervals , i + 1 , end);
    }

    public static void main(String[] args){
        List<Interval> lists = new ArrayList<>();
        lists.add(new Interval(1,4));
        lists.add(new Interval(2,3));
//        lists.add(new Interval(2,4));
//        lists.add(new Interval(3,7));
//        lists.add(new Interval(4,10));
        merge(lists);
        lists.forEach(s -> System.out.println(s.toString()));
    }

}
