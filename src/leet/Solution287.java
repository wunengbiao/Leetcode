package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/1/5.
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
//        Arrays.sort(nums);
//
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]==nums[i+1])
//                return nums[i];
//        }
//
//        return 0;

        int slow=0;
        int fast=0;
        int finder=0;

        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];

            if(slow==fast){
                break;
            }
        }
        while(true){
            slow=nums[slow];
            finder=nums[finder];
            if(slow==finder)
                return slow;
        }
    }

    public static void main(String[] args){
        Solution287 s=new Solution287();
        int[] nums={4,5,2,7,6,2,3,1};
        System.out.println(s.findDuplicate(nums));
    }
}
