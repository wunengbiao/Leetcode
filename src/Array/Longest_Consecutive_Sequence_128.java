package Array;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class Longest_Consecutive_Sequence_128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int res=1;

        int cur=1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) continue;
            if(nums[i]+1==nums[i+1])
                cur++;
            else{
                res=Math.max(res,cur);
                cur=1;
            }
        }

        res=Math.max(res,cur);
        return res;
    }

    public static void main(String[] args){
        Longest_Consecutive_Sequence_128 s=new Longest_Consecutive_Sequence_128();
//        int[] nums={0,-1};
//        int[] nums={100, 4, 200, 1, 3, 2};
        int[] nums={1,2,0,1};
        System.out.println(s.longestConsecutive(nums));
    }
}
