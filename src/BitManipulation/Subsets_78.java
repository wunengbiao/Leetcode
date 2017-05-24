package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/14.
 */
public class Subsets_78 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> solution=new ArrayList<>();

        backtrack(solution,nums,0,nums.length);
        return result;
    }

    public void backtrack(List<Integer> solution,int[] nums,int cur,int n){
        if(n==cur){
            result.add(new ArrayList<>(solution));
            return;
        }else{
            solution.add(nums[cur]);
            backtrack(solution,nums,cur+1,n);
            solution.remove((Object)nums[cur]);
            backtrack(solution,nums,cur+1,n);
        }
    }

    public static void main(String[] args){
        Subsets_78 s=new Subsets_78();
        int[] nums={1,2,3};
        System.out.println(s.subsets(nums));
    }
}