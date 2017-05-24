package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wunengbiao on 2017/4/9.
 */
public class Non_overlapping_Intervals_435 {
    public int eraseOverlapIntervals(Interval[] intervals) {

        if(intervals.length<=1) return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start==o2.start) return o1.end-o2.end;
                return o1.start-o2.start;
            }
        });

        int start=intervals[0].start;
        int end=intervals[0].end;

        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start>=end){
                end=intervals[i].end;
                continue;
            }
            else{
                count++;
                end=Math.min(end,intervals[i].end);
            }
        }

        return count;

    }

    public static void main(String[] args){
        Non_overlapping_Intervals_435 s=new Non_overlapping_Intervals_435();
//        [ [1,2], [2,3], [3,4], [1,3] ]
        Interval[] intervals={new Interval(1,2),new Interval(2,3),new Interval(3,4),new Interval(1,3)};
        System.out.println(s.eraseOverlapIntervals(intervals));
    }
}
