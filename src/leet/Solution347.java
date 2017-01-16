package leet;

import ChinaMobile.Solution;

import java.util.*;

/**
 * Created by wunengbiao on 2017/1/1.
 */
public class Solution347 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int new_nums=map.get(nums[i])+1;
                map.put(nums[i],new_nums);
            }else{
                map.put(nums[i],1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> heap=new PriorityQueue<>(100,(b,a)->(a.getValue()-b.getValue()));
        for(Map.Entry entry:map.entrySet()){
            heap.offer(entry);
        }

        for(int i=0;i<k;i++){
            Map.Entry entry=heap.poll();
            res.add((int)entry.getKey());
        }
        return res;
    }

    public static void main(String[] args){
        Solution347 s=new Solution347();
        int[] nums={1,1,1,2,2,3};
        System.out.println(s.topKFrequent(nums,2));
    }
}
