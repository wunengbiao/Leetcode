package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/14.
 */
public class Subsets_78_2 {

    public List<List<Integer>> subsets(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        int sub_nums= (int) Math.pow(2,n);

        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<sub_nums;i++){

            List<Integer> subset=new ArrayList<>();
            String op="";
            for(int j=0;j<n;j++){
//                System.out.println(i>>j);
                op+=((i>>j) & 1);
                if(((i>>j) & 1)==1) subset.add(nums[j]);
            }
            System.out.println(op);
            System.out.println("-------------");

            res.add(subset);
        }
        return res;
    }

    public static void main(String[] args){
        Subsets_78_2 s=new Subsets_78_2();
        int[] nums={1,2,3};
        System.out.println(s.subsets(nums));
        System.out.println(1>>2);
    }
}
