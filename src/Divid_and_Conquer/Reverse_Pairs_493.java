package Divid_and_Conquer;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/2.
 */
public class Reverse_Pairs_493 {
    public int reversePairs(int[] nums) {
        if(nums.length==0) return 0;
        int[] tmp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            tmp[i]=nums[i];
        }
        return mergeSort(nums,0,nums.length-1,tmp);
    }

    public int mergeSort(int[] nums,int start,int end,int[] tmp){
//        System.out.println(Arrays.toString(nums));
        if(start==end) {
            tmp[start]=nums[start];
            return 0;
        }
        int mid=(end+start)/2;

        int left=mergeSort(nums,start,mid,tmp);
        int right=mergeSort(nums,mid+1,end,tmp);

        int i=start;
        int j=mid+1;

        int index=start;

        int count=0;

        int k=start;
        int z=mid+1;

        while(k<=mid && z<=end){
            if((double)nums[k]>(double)2*nums[z]){
                count+=mid-k+1;
                z++;
            }else{
                k++;
            }
        }

        while (i<=mid && j<=end){
            if(nums[i]>nums[j]){
                tmp[index++]=nums[j++];
            }else{
                tmp[index++]=nums[i++];
            }
        }

        for(;i<=mid;i++){
            tmp[index++]=nums[i];
        }
        for(;j<=end;j++){
            tmp[index++]=nums[j];
        }

        for(int x=start;x<=end;x++){
            nums[x]=tmp[x];
        }
        return left+right+count;
    }

    public static void main(String[] args){
        Reverse_Pairs_493 s=new Reverse_Pairs_493();
//        int[] nums=new int[]{1,3,2,3,1};
        int[] nums=new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(Integer.MAX_VALUE);
        System.out.println(s.reversePairs(nums));
        System.out.println(Arrays.toString(nums));
    }
}
