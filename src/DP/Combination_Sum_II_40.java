package DP;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by wunengbiao on 2017/5/27.
 */
public class Combination_Sum_II_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combination(candidates,target,0);
    }

    public List<List<Integer>> combination(int[] candidates,int target,int start){
        List<List<Integer>> list=new ArrayList<>();
        if(candidates==null || candidates.length==0) return list;
        int last=0;

        for(int i=start;i<candidates.length;i++){
            if(candidates[i]==last) continue;
            if(candidates[i]<target) {
                List<List<Integer>> tlist = combination(candidates, target - candidates[i], i + 1);
                if (tlist.size() > 0) {
                    for (List<Integer> alist : tlist) {
                        alist.add(0, candidates[i]);
                    }
                    list.addAll(tlist);
                }
            }
            else if(candidates[i]==target){
                List<Integer> tlist=new ArrayList<>();
                tlist.add(target);
                list.add(tlist);
            }
            last=candidates[i];

        }
        return list;
    }

    public static void main(String[] args){
        Combination_Sum_II_40 s=new Combination_Sum_II_40();
        int[] nums={10,1,2,7,6,1,5};
        System.out.println(s.combinationSum2(nums,8));
    }
}
