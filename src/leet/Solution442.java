package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/1/4.
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int count=map.get(nums[i]);
                map.put(nums[i],count+1);
            }else{
                map.put(nums[i],1);
            }
        }

        List<Integer> res=new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getValue()==2){
                res.add((int)entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution442 s=new Solution442();
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(s.findDuplicates(nums));
    }
}
