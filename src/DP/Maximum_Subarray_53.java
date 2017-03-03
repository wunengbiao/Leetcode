package DP;

/**
 * Created by wunengbiao on 2017/2/22.
 */
public class Maximum_Subarray_53 {

    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max=Integer.MIN_VALUE;
        int[] dp=new int[nums.length];
        int sum=0;
        for(int i=0;i< nums.length;i++){
            if(sum<0)
                sum=nums[i];
            else
                sum+=nums[i];
            dp[i]=sum;
            max=Math.max(max,sum);
        }
        return max;
    }

    public static void main(String[] args){
        Maximum_Subarray_53 s=new Maximum_Subarray_53();
        int[] test={-2,1,-3,4,-1,2,1,-5,4};
        int[] test2={-1};
        System.out.println("The Result is:"+s.maxSubArray(test2));
    }
}
