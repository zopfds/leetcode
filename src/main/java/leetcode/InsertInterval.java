package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 *
 * @author jianbo.pan@mljr.com
 * @version ${VERSION}
 * @create 2018/12/20
 */
public class InsertInterval {
    private static  class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0 , count = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            i++;
        }
        if(i == intervals.size()){
            intervals.add(newInterval);
            return intervals;
        }
        int min = i;
        while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
            i++;
            count++;
        }
        if(min == i){
            int oldSize = intervals.size();
            intervals.add(new Interval(intervals.get(intervals.size() - 1).start , intervals.get(intervals.size() - 1).end));
            for(int j = oldSize - 1 ; j >= min ; j --){
                intervals.set(j + 1 , intervals.get(j));
            }
            intervals.set(min , newInterval);
            return intervals;
        }
        intervals.get(min).start = Math.min(intervals.get(min).start , newInterval.start);
        intervals.get(min).end = Math.max(newInterval.end , intervals.get(i - 1).end);
        while(i < intervals.size()){
            intervals.set(i - count + 1 , intervals.get(i));
            i++;
        }
        return intervals.subList(0 , intervals.size() - count + 1);
    }

    public static void main(String[] args){
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6 , 7);
        Interval i4 = new Interval(8 , 10);
        Interval i5 = new Interval(12 , 16);
        Interval newInterval = new Interval(4,8);
        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        list.add(i5);
        List<Interval> result = insert(list , newInterval);
    }
}
