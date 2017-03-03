package DP;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/2.
 */
public class Product_of_Array_Except_Self_238 {
    public int[] productExceptSelf(int[] nums) {

        int product=1;
        int count=0;
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && count==0){
                count++;
                continue;
            }else{
                product*=nums[i];
            }

        }

        if(count>1) return result;
        if(count==1){
            for(int i=0;i<nums.length;i++){
                result[i]=nums[i]==0?product:0;
            }
        }

        if(count==0){
            for(int i=0;i<nums.length;i++){
                result[i]=product/nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        Product_of_Array_Except_Self_238 s=new Product_of_Array_Except_Self_238();
        int[] nums={1,0};
        System.out.println(Arrays.toString(s.productExceptSelf(nums)));
    }
}
