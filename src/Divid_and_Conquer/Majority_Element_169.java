package Divid_and_Conquer;

/**
 * Created by wunengbiao on 2017/3/27.
 */
public class Majority_Element_169 {
    public int majorityElement(int[] nums) {
        int major=nums[0],count=1;

        for(int i=1;i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }
            if(major==nums[i]){
                count++;
            }else{
                count--;
            }
        }

        return major;
    }

//    public int findNth(int[] nums,int start,int end,int n){
//        int i=start;
//        int j=end;
//
//        int tmp=nums[end];
//        while(i<j){
//            while(i<j && nums[i]<=tmp) i++;
//            nums[j]=nums[i];
//            while(i<j && nums[j]>=tmp) j--;
//            nums[i]=nums[j];
//        }
//        nums[i]=tmp;
//
//        if(n==i) return nums[n];
//        if(n<i) return findNth(nums,start,i-1,n);
//        else return findNth(nums,i+1,end,n);
//    }

}
