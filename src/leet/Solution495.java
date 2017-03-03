package leet;

/**
 * Created by wunengbiao on 2017/2/12.
 */
public class Solution495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==0) return 0;
        int time=0;
        for(int i=1;i<timeSeries.length;i++){
            int diff=timeSeries[i]-timeSeries[i-1];
            time+=(diff>duration)?duration:diff;
        }
        return time+duration;
    }

    public static void main(String[] args){
        Solution495 s=new Solution495();
        int[] timeSeries={1,2};
        System.out.println(s.findPoisonedDuration(timeSeries,2));
    }
}
