package leet;

/**
 * Created by wunengbiao on 2017/2/14.
 */
public class Solution494 {

    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(S)>sum) return 0;
        bfs(nums,0,0,S);
        return count;
    }


    public void bfs(int[] nums,int sum,int i,int S){
        if(i>nums.length-1){
            if(sum==S) count++;
            return;
        }
        bfs(nums,sum+nums[i],i+1,S);
        bfs(nums,sum-nums[i],i+1,S);
    }

    public static void main(String[] args){
        Solution494 s=new Solution494();
        int[] nums={1,1,1,1,1};
        int S=3;
        System.out.println("Result is:"+s.findTargetSumWays(nums,S));
    }
}
