package leet;

import ChinaMobile.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/30.
 */
public class Solution315 {

    List<Integer> result=new ArrayList<>();
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> sortedArr=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int x=findIndex(sortedArr,nums[i]);
            result.add(0,x);
            sortedArr.add(x,nums[i]);
        }

        return result;
    }

    public int findIndex(List<Integer> sortedArr,int target){

        if(sortedArr.size()==0) return 0;
        int start=0;
        int end=sortedArr.size()-1;


        while(start<=end){
            int mid=(start+end)/2;
            if(target<=sortedArr.get(mid)){
                end=mid-1;
            }
            if(target>sortedArr.get(mid)){
                start=mid+1;
            }
        }
        return start;

    }

    public static void main(String[] args){
        Solution315 s=new Solution315();
//        int index=s.findIndex(Arrays.asList(2,4,5,6),2);
        int[] nums={5,2,6,1};
        List<Integer>ret=s.countSmaller(nums);
        System.out.println(ret);
    }

}
