package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/3/24.
 */
public class Insert_Interval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result=new ArrayList<>();
        int i=0;

        while(i<intervals.size() && intervals.get(i).end<newInterval.start) result.add(intervals.get(i++));

        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){
            newInterval=new Interval(Math.min(newInterval.start,intervals.get(i).start),
                    Math.max(intervals.get(i).end,newInterval.end));
            i++;
        }

        result.add(newInterval);

        while(i<intervals.size()) result.add(intervals.get(i++));

        return result;
    }

    public static void main(String[] args){
        Insert_Interval_57 solution=new Insert_Interval_57();
    }
}
