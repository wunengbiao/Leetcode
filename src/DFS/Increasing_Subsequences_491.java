package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/6/8.
 */
public class Increasing_Subsequences_491 {

    public List<List<Integer>> findSubsequences(int[] nums){
        Set<List<Integer>> res=new HashSet<>();
        List<Integer> holder=new ArrayList<>();
        findSequence(res,holder,0,nums);
        List result=new ArrayList(res);
        return result;
    }

    public void findSequence(Set<List<Integer>> res,List<Integer> holder,int index,int[] nums){
        if(holder.size()>=2){
            res.add(new ArrayList<>(holder));
        }
        for(int i=index;i<nums.length;i++){
            if(holder.size()==0 || holder.get(holder.size()-1)<=nums[i]){
                holder.add(nums[i]);
                findSequence(res,holder,i+1,nums);
                holder.remove(holder.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Increasing_Subsequences_491 s=new Increasing_Subsequences_491();
        int[] nums={4,6,7,7};
//        int[] nums={4,3,2,1};
        System.out.println(s.findSubsequences(nums));
    }
}
