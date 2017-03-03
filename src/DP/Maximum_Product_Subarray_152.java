package DP;

/**
 * Created by wunengbiao on 2017/3/2.
 */
public class Maximum_Product_Subarray_152 {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=max;
            max=Math.max(nums[i]*max,Math.max(nums[i]*min,nums[i]));
            min=Math.min(nums[i]*temp,Math.min(nums[i]*min,nums[i]));

            if(max>result)
                result=max;
        }

        return result;
    }

    public static void main(String[] args){
        Maximum_Product_Subarray_152 s=new Maximum_Product_Subarray_152();
        int[] nums={2,3,-2,4};
        System.out.println(s.maxProduct(nums));
    }
}
