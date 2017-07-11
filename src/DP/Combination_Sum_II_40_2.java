package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/28.
 */
public class Combination_Sum_II_40_2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates,target,0);
    }

    public List<List<Integer>> helper(int[] candidates,int target,int start){
        List<List<Integer>> list=new ArrayList<>();
        if(candidates==null || candidates.length==0) return list;

        int last=0;
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]==last) continue;
            if(candidates[i]<target){
                List<List<Integer>> tlist=helper(candidates,target-candidates[i],i+1);
                if(tlist.size()>0){
                    for(List<Integer> alist:tlist){
                        alist.add(0,candidates[i]);
                    }
                    list.addAll(tlist);
                }
            }else if(candidates[i]==target){
                List<Integer> tlist=new ArrayList<>();
                tlist.add(target);
                list.add(tlist);
            }

            last=candidates[i];
        }
        return list;
    }

    public static void main(String[] args){

    }
}
