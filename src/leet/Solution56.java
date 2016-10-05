package leet;

/**
 * Created by wunengbiao on 2016/10/3.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    public static class Interval{
        int start;
        int end;
        Interval(){
            start=0;
            end=0;
        }

        Interval(int s,int e){
            start=s;
            end=e;
        }

        @Override
        public String toString() {
            return "["+start+","+end+"]";
        }
    }

    public class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }


     public List<Interval> merge(List<Interval> intervals) {

         if(intervals.size()==1 || intervals.size()==0) return intervals;
         List<Interval> result=new ArrayList<>();
         Collections.sort(intervals,new IntervalComparator());
         int n=intervals.size();
         Interval temp=intervals.get(0);

         Interval max=temp;
         for(int i=1;i<n;i++){
             if(intervals.get(i).start<=temp.end){
                 if(intervals.get(i).end>max.end){
                     max=intervals.get(i);
                     temp.end=max.end;
                 }
                 if(i==n-1){
                     Interval ret=new Interval(temp.start,max.end);
                    result.add(ret);
                 }

             }else{
                 Interval ret=new Interval(temp.start,max.end);
                 result.add(ret);
                 temp=max=intervals.get(i);
                 i=i-1;
             }
         }

         return result;
    }

    public static void main(String[] args){
        Solution56 s=new Solution56();
        List<Interval> test=new ArrayList<>();
        test.add(new Interval(1,4));
        test.add(new Interval(0,2));
        test.add(new Interval(3,5));
        List<Interval>ret=s.merge(test);
        System.out.println(ret);
    }
}
