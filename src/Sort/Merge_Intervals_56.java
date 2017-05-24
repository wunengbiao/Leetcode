package Sort;


import com.sun.scenario.effect.Merge;

import java.util.*;

/**
 * Created by wunengbiao on 2017/3/24.
 */
public class Merge_Intervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<2) return intervals;
        Collections.sort(intervals,(intervals1,intervals2)->intervals1.start-intervals2.start);
        List<Interval> res=new ArrayList<>();

        Interval cur=new Interval(intervals.get(0).start,intervals.get(0).end);
        for(int i=0;i<intervals.size();i++){
            if(cur.end>=intervals.get(i).start){
                cur.end= Math.max(cur.end,intervals.get(i).end);

                if(i==intervals.size()-1){
                    res.add(new Interval(cur.start,cur.end));
                }
            }else {
                res.add(new Interval(cur.start,cur.end));
                cur.start=intervals.get(i).start;
                cur.end=intervals.get(i).end;
                i-=1;
            }

        }

        return res;

    }

    public static void main(String[] args){
        Merge_Intervals_56 solution=new Merge_Intervals_56();
        //[1,3],[2,6],[8,10],[15,18]
        Interval interval1=new Interval(1,4);
        Interval interval2=new Interval(2,6);
        Interval interval3=new Interval(8,10);
        Interval interval4=new Interval(15,18);


        List<Interval> intervals=new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        System.out.println(solution.merge(intervals));
    }
}
