package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/30.
 */
public class Solution315_2 {


    List<Integer> ret=new ArrayList<>();
    public List<Integer> countSmaller(int[] nums) {
        int[] result=new int[nums.length];



        for(int i=0;i<result.length;i++){
            ret.add(result[i]);
        }
        return ret;
    }

    public void mergeSort(int[] nums,int start,int end,int[] result){
        if(end-start<1){
            if(end-start==1){
                if(nums[start]>nums[end]) result[start]++;
                int tmp=nums[start];
                nums[start]=nums[end];
                nums[end]=tmp;
            }
            return;
        }

        int mid=(start+end)/2;
        mergeSort(nums,start,mid,result);
        mergeSort(nums,mid+1,end,result);

    }

}
