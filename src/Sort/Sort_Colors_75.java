package Sort;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/24.
 */
public class Sort_Colors_75 {
    public void sortColors(int[] nums) {
        int[] colors=new int[3];
        for(int i=0;i<nums.length;i++){
            colors[nums[i]]++;
        }

        int j=0;
        for(int i=0;i<3;i++){
            while(colors[i]-->0){
                nums[j++]=i;
            }
        }
    }

    public static void main(String[] args){
        Sort_Colors_75 solution=new Sort_Colors_75();
        int[] nums={0,1,0,2,1,2,1,0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
