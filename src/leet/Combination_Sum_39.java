package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/29.
 */
public class Combination_Sum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates,target,0);
    }

    public List<List<Integer>> helper(int[] candidates,int target,int last){
        List<List<Integer>> list=new ArrayList<>();
        if(candidates==null || candidates.length==0) return list;

        for(int i=0;i<candidates.length;i++){
            if(candidates[i]<last) continue;
            if(candidates[i]<target){
                List<List<Integer>> tlist=helper(candidates,target-candidates[i],candidates[i]);
                if(tlist.size()>0){
                    for(List<Integer> alist:tlist){
                        alist.add(0,candidates[i]);
                    }
                    list.addAll(tlist);
                }
            }
            else if(candidates[i]==target){
                List<Integer> tlist=new ArrayList<>();
                tlist.add(target);
                list.add(tlist);
            }
        }
        return list;
    }


    public static void main(String[] args){
        Combination_Sum_39 s=new Combination_Sum_39();
        int[] nums={2, 3, 6, 7};
        System.out.println(s.combinationSum(nums,7));
    }
}
