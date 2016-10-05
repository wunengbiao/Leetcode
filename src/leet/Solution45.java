package leet;

/**
 * Created by wunengbiao on 2016/10/5.
 */
public class Solution45 {

     public int jump(int[] nums) {

         int n=nums.length;
         if(n==1) return 0;
         if(n==2) return 1;
         int[] dp=new int[n];
         dp[0]=0;

         int count=-1;
         for(int i=0;i<n-1;i++){
             dp[i+1]=Math.max(dp[i]-1,nums[i]);
             if(dp[i+1]+i>=n-1 && dp[i+1]!=nums[i]){
                 count++;
                 break;
             }
             if(dp[i+1]+i>=n-1 && dp[i+1]==nums[i]){
                 count+=2;
                 break;
             }
             if(dp[i+1]==nums[i] && dp[i+1]+i<n-1) count++;

         }
         return count;
    }

    public static void main(String[] args){
        int[] nums={2,3,1,1,4};
        int[] nums2={2,1,3};
        int[] nums3={1,2,3};
        int[] nums4={2,3,1};
        int[] nums5={1,2,1,1,1};
        Solution45 s=new Solution45();
        int ret=s.jump(nums5);
        System.out.println(ret);
    }
}
