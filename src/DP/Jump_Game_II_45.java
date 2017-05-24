package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/7.
 */
public class Jump_Game_II_45 {
    public int jump(int[] nums) {
        if(nums.length<=1) return 0;
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,n+1);
        dp[0]=0;

        for(int i=1;i<n;i++){
            int step=nums[i-1];

            if(step!=0)
            for(int j=i;j<Math.min(i+step,n);j++){
                dp[j]=Math.min(dp[j],dp[i-1]+1);
            }

            System.out.println(Arrays.toString(dp));
        }


        return dp[n-1]==n+1?0:dp[n-1];
    }

    public static void main(String[] args){
        Jump_Game_II_45 s=new Jump_Game_II_45();

//        int[] array={2,3,1,1,4};
//        int[] array={0};
//        int[] array={1,3,3,4};

        int[] nums={2,3,1,1,4};
        int[] nums2={2,1,3};
        int[] nums3={1,2,3};
        int[] nums4={2,3,1};
        int[] nums5={1,2,1,1,1};
        int[] nums6={1,1,1,1};
        System.out.println(s.jump(nums5));
    }
}
