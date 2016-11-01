package leet;

/**
 * Created by wunengbiao on 2016/10/22.
 *
 * Analysis:if sum(cost)>=sum(gas),must have a solution to complete this circuit!
 *
 */
public class Solution134 {
     public int canCompleteCircuit(int[] gas, int[] cost) {
         int start=gas.length, end=0, sum=0;
         do sum+= sum>0? gas[end]-cost[end++]: gas[--start]-cost[start]; while (start!=end);
         return sum>=0? start: -1;
    }

    public static void main(String[] args){
        int[] gas={2,3,4,5};
        int[] cost={1,2,3,7};
        Solution134 s=new Solution134();
        System.out.println(s.canCompleteCircuit(gas,cost));
    }
}
