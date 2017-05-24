package Sort;


import java.util.Arrays;
/**
 * Created by wunengbiao on 2017/3/26.
 */
public class Wiggle_Sort_II_324 {
    public void wiggleSort(int[] nums) {
        int mid=(nums.length+1)/2;
        quickSort(nums,mid,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        int i=0,j=0,k=nums.length-1;

        int n=nums.length;
        while(j<=k){
            if(nums[(1+2*i)%(n|1)]>nums[mid]){
                int tmp=nums[(1+2*i)%(n|1)];
                nums[(1+2*i)%(n|1)]=nums[(1+2*j)%(n|1)];
                nums[(1+2*j)%(n|1)]=tmp;
                i++;j++;
            }
            else if(nums[(1+2*i)%(n|1)]<nums[mid]){
                int tmp=nums[(1+2*k)%(n|1)];
                nums[(1+2*k)%(n|1)]=nums[(1+2*j)%(n|1)];
                nums[(1+2*j)%(n|1)]=tmp;
                k--;
            }
            else j++;
        }

    }

    public void quickSort(int[] nums,int k,int start,int end){
        int i=start;
        int j=end;
        int tmp=nums[end];
        while(i<j){
            while(i<j && nums[i]>=tmp) i++;
            nums[j]=nums[i];

            while(i<j && tmp>=nums[j]) j--;
            nums[i]=nums[j];
        }

        nums[i]=tmp;

        if(i==k) return;
        if(i<k) quickSort(nums,k,i+1,end);
        else quickSort(nums,k,start,i-1);
    }

    public static void main(String[] args){
        Wiggle_Sort_II_324 solution=new Wiggle_Sort_II_324();
        int[] nums={1,3,2,2,3,1};
//        solution.quickSort(nums,5,0,9);
//        System.out.println(Arrays.toString(nums));
        solution.wiggleSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
