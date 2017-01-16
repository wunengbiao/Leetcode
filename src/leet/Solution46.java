package leet;

import ChinaMobile.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/1/5.
 */
public class Solution46 {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permute(nums,0);
        return result;
    }

    List<Integer> list=new ArrayList<>();
    public void permute(int[] nums,int i){

        if(i>=nums.length){

            System.out.println(Arrays.toString(nums));
            list.clear();
            for(int k=0;k<nums.length;k++){
                list.add(nums[k]);
            }
            System.out.println(list+"-->");

            result.add(new ArrayList<>(list));
            return;
        }

        for(int x=i;x<nums.length;x++){

            swap(nums,x,i);

            permute(nums,i+1);

            swap(nums,x,i);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args){
        Solution46 s=new Solution46();
        int[] nums={1,2,3};
        List<List<Integer>>res=s.permute(nums);
        System.out.println(res);
    }
}
