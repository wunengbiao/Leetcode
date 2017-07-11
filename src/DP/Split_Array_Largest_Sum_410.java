package DP;

/**
 * Created by wunengbiao on 2017/5/25.
 */
public class Split_Array_Largest_Sum_410 {
    public int splitArray(int[] nums, int m) {

        long sum=0;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        return (int)binarySearch(nums,m,sum,max);
    }

    private long binarySearch(int[] nums,int m,long high,long low){
        long mid=0;
        while(low<high){
            mid=(high+low)/2;
            if(valid(nums,m,mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return high;
    }

    private boolean valid(int[] nums,int m,long max){
        int cur=0;
        int count=1;

        for(int num:nums){
            cur+=num;
            if(cur>max){
                cur=num;
                count++;
                if(count>m){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        Split_Array_Largest_Sum_410 s=new Split_Array_Largest_Sum_410();
        int[] nums={1,2,3,4,5};
        System.out.println(s.splitArray(nums,2));
    }
}
