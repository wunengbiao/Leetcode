package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/6/17.
 */
public class Permutations_II_47 {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if(num==null && num.length==0)
            return res;
        Arrays.sort(num);
        helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int[] num, boolean[] used, ArrayList<Integer> item, List<List<Integer>> res)
    {
        if(item.size() == num.length)
        {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=0;i<num.length;i++)
        {
            if(i>0 && !used[i-1] && num[i]==num[i-1]) continue;
            if(!used[i])
            {
                used[i] = true;
                item.add(num[i]);
                helper(num, used, item, res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Permutations_II_47 s=new Permutations_II_47();
        int[] nums={2,2,1,1};
        System.out.println(s.permuteUnique(nums));
    }
}
