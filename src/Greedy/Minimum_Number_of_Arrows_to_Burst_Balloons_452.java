package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wunengbiao on 2017/4/9.
 */
public class Minimum_Number_of_Arrows_to_Burst_Balloons_452 {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0) return 0;
        if(points.length==1) return 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        int count=0;
        int start=points[0][0];int end=points[0][1];
        for(int i=1;i<points.length;i++){
           if(points[i][0]>=start && points[i][0]<=end){
               start=points[i][0];
               end=Math.min(end,points[i][1]);
               if(i==points.length-1) count++;
               continue;
           }
           else{
               count++;
               if(i<points.length-1){
                   start=points[i][0];
                   end=points[i][1];
               }
               else if(i==points.length-1) count++;
           }
        }

        return count;
    }

    public static void main(String[] args){
        Minimum_Number_of_Arrows_to_Burst_Balloons_452 s=new Minimum_Number_of_Arrows_to_Burst_Balloons_452();
//        int[][] points={{10,16}, {2,8}, {1,6}, {7,12}};
//        int[][] points={{1,2}};
        int[][] points={{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(s.findMinArrowShots(points));
    }
}
