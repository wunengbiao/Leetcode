package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/4/5.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        if(nums.length<3) return results;
        Arrays.sort(nums);

        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            if(i>0 && nums[i]==nums[i-1]) continue;

            int k=n-1;

            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                    while(j<k && nums[j]==nums[j-1]) j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }else{
                    List<Integer> res=Arrays.asList(nums[i],nums[j],nums[k]);
                    results.add(res);
                    j++;
                    k--;
                    while(nums[j]==nums[j-1] && nums[k]==nums[k+1]) j++;
                }

            }
        }

        return results;
    }

    public static void main(String[] args){
        ThreeSum_15 s=new ThreeSum_15();
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(nums));

    }
}
