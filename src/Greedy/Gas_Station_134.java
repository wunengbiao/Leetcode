package Greedy;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class Gas_Station_134 {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int start=gas.length-1;
//        int end=0;
//
//        int sum=gas[start]-cost[start];
//        while(start>end){
//            if(sum>=0){
//                sum+=gas[end]-cost[end];
//                ++end;
//            }else{
//                --start;
//                sum+=gas[start]-cost[start];
//            }
//        }
//
//        return sum>=0?start:-1;
//    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        int tank=0;
        int start=0;

        for(int i=0;i<gas.length;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                total+=tank;
                tank=0;
                start=i+1;
            }
        }

        return total+tank<0?-1:start;
    }



    public static void main(String[] args){

    }
}

