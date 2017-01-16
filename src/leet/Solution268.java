package leet;

import ChinaMobile.Solution;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/1/5.
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int n=nums.length;

        boolean findLast=false;
        for(int i=0;i<n;i++){
            int m=nums[i];
            if(m>n) m-=(n+1);
            if(m==n) {
                findLast = true;
            }else{
                nums[m]+=(n+1);
            }
        }

        if(!findLast) return n;
        else{
            for(int i=0;i<n;i++){
                if(nums[i]<(n+1)) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Solution268 s=new Solution268();
        int[] nums={1,0,3,5,4,10,8,9,7,6};
        int res=s.missingNumber(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}
