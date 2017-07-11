package Sort;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/7/2.
 */
public class SortUtils {
    public void quick_sort(int[] nums,int start,int end){
        if(start>=end) return;
        int i=start;
        int j=end;

        int tmp=nums[end];
        while(i<j){
            while(nums[i]<=tmp && i<j) i++;
            nums[j]=nums[i];
            while(tmp<=nums[j] && i<j) j--;
            nums[i]=nums[j];
        }
        nums[i]=tmp;
        quick_sort(nums,start,j-1);
        quick_sort(nums,j+1,end);
    }

    public static void main(String[] args){
        SortUtils s=new SortUtils();
        int[] nums={1,9,2,5,4,3,0,8,7,6};
        s.quick_sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
