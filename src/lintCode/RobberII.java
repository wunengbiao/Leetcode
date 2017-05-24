package lintCode;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/3.
 */
public class RobberII {
    public int houseRobber2(int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        if(nums.length==1) return nums[0];
        int[] rob=new int[nums.length];
        int[] not=new int[nums.length];

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            rob[i+1]=not[i]+nums[i];
            max=Math.max(max,rob[i+1]);
            not[i+1]=Math.max(not[i],rob[i]);
            max=Math.max(max,not[i+1]);
        }

        Arrays.fill(rob,0);
        Arrays.fill(not,0);

        for(int i=1;i<nums.length;i++){
            rob[i]=not[i-1]+nums[i];
            max=Math.max(max,rob[i]);
            not[i]=Math.max(not[i-1],rob[i-1]);
            max=Math.max(max,not[i]);
        }

        return max;
    }

    public static void main(String[] args){
        RobberII s=new RobberII();
//        int[] nums={3,6,4};
//        int[] nums={6,2,2,5,1};
        int[] nums={2,4};
        System.out.println(s.houseRobber2(nums));
    }
}
