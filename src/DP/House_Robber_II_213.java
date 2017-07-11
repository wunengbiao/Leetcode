package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/6/13.
 */
public class House_Robber_II_213 {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int[] rob=new int[nums.length];
        int[] not=new int[nums.length];
        rob[0]=nums[0];
        for(int i=1;i<nums.length-1;i++){
            rob[i]=Math.max(not[i-1]+nums[i],rob[i-1]);
            not[i]=Math.max(rob[i-1],not[i-1]);
        }
        int res=0;
        res=Math.max(rob[nums.length-2],not[nums.length-2]);

        Arrays.fill(rob,0);
        Arrays.fill(not,0);

        rob[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            rob[i]=Math.max(not[i-1]+nums[i],rob[i-1]);
            not[i]=Math.max(rob[i-1],not[i-1]);
        }

        res=Math.max(res,Math.max(rob[nums.length-1],not[nums.length-1]));
        return res;
    }

    public static void main(String[] args){
        House_Robber_II_213 s=new House_Robber_II_213();
        int[] nums={1,2,1,0};
        System.out.println(s.rob(nums));
    }
}
