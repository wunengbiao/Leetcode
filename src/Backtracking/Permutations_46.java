package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/6/16.
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        helper(nums,0,nums.length);
        return res;
    }

    List<List<Integer>> res=new ArrayList<>();
    public void helper(int[] nums,int start,int end){
        if(start>=end){
            List<Integer> l=new ArrayList<>();
            for(int x=0;x<nums.length;x++){
                l.add(nums[x]);
            }
            res.add(l);
            return;
        }
        for(int i=start;i<end;i++){
            int temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;

            helper(nums,start+1,end);
//            int temp2=nums[i];
//            nums[i]=nums[start];
//            nums[start]=temp2;
        }
    }

    public static void main(String[] args){
        Permutations_46 s=new Permutations_46();
        int[] nums={1,2,3};
        System.out.println(s.permute(nums));
    }
}
