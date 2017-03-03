package leet;

/**
 * Created by wunengbiao on 2017/2/15.
 */
public class Solution410 {

    public int splitArray(int[] nums, int m) {
        int max=0;long sum=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            sum+=nums[i];
        }

        if(m==1) return (int)sum;
        long l=max;
        long r=sum;

        while(l<=r){
            long mid=(l+r)/2;
            if(isValid(nums,m,mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return (int)l;
    }

    public boolean isValid(int[] nums,int m,long max){
        int count=1;
        int cur=0;

        for(int num:nums){
            cur+=num;
            if(cur>max) {
                cur=num;
                count++;
            }
            if(count>m)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution410 s=new Solution410();
        int[] nums={7,2,5,10,8};
        System.out.println(s.splitArray(nums,2));
    }
}
