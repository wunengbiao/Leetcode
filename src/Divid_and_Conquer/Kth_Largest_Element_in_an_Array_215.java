package Divid_and_Conquer;

/**
 * Created by wunengbiao on 2017/3/27.
 */
public class Kth_Largest_Element_in_an_Array_215 {
    public int findKthLargest(int[] nums, int k) {
        return findNth(nums,0,nums.length-1,k-1);
    }

    public int findNth(int[] nums,int start,int end,int n){
        int i=start;
        int j=end;

        int tmp=nums[end];
        while(i<j){
            while(i<j && nums[i]>=tmp) i++;
            nums[j]=nums[i];
            while(i<j && nums[j]<=tmp) j--;
            nums[i]=nums[j];
        }
        nums[i]=tmp;

        if(n==i) return nums[n];
        if(n<i) return findNth(nums,start,i-1,n);
        else return findNth(nums,i+1,end,n);
    }

    public static void main(String[] args){
        Kth_Largest_Element_in_an_Array_215 s=new Kth_Largest_Element_in_an_Array_215();
        int[] nums={3,2,1,5,6,4};
        System.out.println(s.findKthLargest(nums,2));

    }
}
