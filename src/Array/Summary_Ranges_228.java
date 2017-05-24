package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class Summary_Ranges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums.length==0 || nums==null) return res;

//        Arrays.sort(nums);

        int start=nums[0];
        int end=nums[0];

        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]==nums[i+1]) continue;
            if(nums[i]+1==nums[i+1]){
                end=nums[i+1];
            }else{
                if(start==end) res.add(start+"");
                else res.add(start+"->"+end);

                start=nums[i+1];
                end=nums[i+1];
            }
        }

        if(start==end) res.add(start+"");
        else res.add(start+"->"+end);

        return res;
    }

    public static void main(String[] args){
        Summary_Ranges_228 s=new Summary_Ranges_228();
        int[] nums={0,1,2,4,5,7};
        System.out.println(s.summaryRanges(nums));
    }
}
