package Array;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int cur=nums[0];

        int begin=0;
        int end=0;

        int head=0;
        int tail=0;

        for(int i=0;i<nums.length;i++){
            cur=nums[i]+(cur>0?cur:0);
            max=Math.max(cur,max);
        }
        return max;
    }

    public static void main(String[] args){
        Maximum_Subarray_53 s=new Maximum_Subarray_53();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums));
    }
}
