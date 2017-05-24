package Sort;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/27.
 */
public class QS {
    public void quickSort(int[] nums,int k,int start,int end){
        int i=start;
        int j=end;
        int tmp=nums[end];
        while(i<j){
            while(i<j && nums[i]<=tmp) i++;
            nums[j]=nums[i];

            while(i<j && tmp<=nums[j]) j--;
            nums[i]=nums[j];
        }

        System.out.println("i:"+i+",j:"+j);
        nums[i]=tmp;

        if(i==k) return;
        if(i<k) quickSort(nums,k,i+1,end);
        else quickSort(nums,k,start,i-1);
    }

    public static void main(String[] args){
        QS qs=new QS();

        int[] nums={1,9,2,5,4,3,0,8,7,6};
        qs.quickSort(nums,5,0,9);

        System.out.println(Arrays.toString(nums));
    }
}
