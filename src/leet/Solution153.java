package leet;

import ChinaMobile.Solution;

/**
 * Created by wunengbiao on 2017/2/13.
 */
public class Solution153 {
    public int findMin(int[] nums) {

        int left=0;
        int right=nums.length-1;

        while(left<=right){

            if(nums[left]<nums[right]) return nums[left];
        }

        return 0;
    }

    public static void main(String[] args){
        Solution153 s=new Solution153();
        int[] test={4,5,6,7,1,2,9};
        int[] test2={1,2};

        System.out.println("The min value is :"+s.findMin(test));
    }
}
