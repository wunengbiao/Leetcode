package leet;

import SouHu.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wunengbiao on 2016/10/16.
 */
public class Solution128 {
     public int longestConsecutive(int[] nums) {

         int ret=0;
         Map<Integer,Boolean> map=new HashMap<>();
         for(int i=0;i<nums.length;i++){
             map.put(nums[i],false);
         }

         for(int i=0;i<nums.length;i++){
             if(map.get(nums[i])==false){
                 int cur=1;
                 int left=nums[i]-1;

                 while(map.containsKey(left) && map.get(left)==false){
                     map.put(left,true);
                     cur++;
                     left--;
                 }

                 int right=nums[i]+1;
                 while(map.containsKey(right) && map.get(right)==false){
                     map.put(right,true);
                     cur++;
                     right++;
                 }

                 ret=Math.max(ret,cur);
             }
         }

        return ret;
    }

    public static void main(String[] args){
        int[]test={100,4,200,1,3,2};
        Solution128 s=new Solution128();
        int ret=s.longestConsecutive(test);
        System.out.println(ret);
    }
}
