package Greedy;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/12.
 */
public class Create_Maximum_Number_321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result=new int[k];
        for(int i=Math.max(k-nums2.length,0);i<=Math.min(nums1.length,k);i++){
            int[] result1=findMaxKValues(nums1,i);
            int[] result2=findMaxKValues(nums2,k-i);
            int[] temp=new int[k];
            int pos1=0;
            int pos2=0;
            int tpos=0;

            while(pos1<result1.length || pos2<result2.length){
                temp[tpos++]=greater(result1,pos1,result2,pos2)?result1[pos1++]:result2[pos2++];
            }

            if(!greater(result,0,temp,0)) result=temp;
        }

        return result;
    }

    public boolean greater(int[] nums1,int n1,int[] nums2,int n2){
        while(n1<nums1.length && n2<nums2.length){
            if(nums1[n1]>nums2[n2]) return true;
            if(nums1[n1]<nums2[n2]) return false;
            n1++;
            n2++;
        }
        return n1!=nums1.length;
    }

    public int[] findMaxKValues(int[] nums,int k){
        int[] res=new int[k];
        int len=0;

        for(int i=0;i<nums.length;i++){
            while(len>0 && len+nums.length-i>k && res[len-1]<nums[i]){
                len--;
            }
            if(len<k){
                res[len++]=nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args){
        /*
        *
            nums1 = [3, 4, 6, 5]
            nums2 = [9, 1, 2, 5, 8, 3]
        * */

        int[] nums1={3,4,6,5};
        int[] nums2={9, 1, 2, 5, 8, 3};
        Create_Maximum_Number_321 s=new Create_Maximum_Number_321();
        System.out.println(Arrays.toString(s.maxNumber(nums1,nums2,5)));
    }
}
