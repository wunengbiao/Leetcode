package NowCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/6.
 */
public class Intresting_Sort {
    public int sort(int[] nums){

        int[] sort=new int[nums.length];
        sort=Arrays.copyOf(nums,nums.length);
        Arrays.sort(sort);

        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==sort[count])
                count++;
        }
        return nums.length-count;
    }

    public static void main(String[] args){
        Intresting_Sort s=new Intresting_Sort();
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] nums=new int[n];
        String[] strs=in.nextLine().split(" ");
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(strs[i]);
        }
        System.out.println(s.sort(nums));
    }
}
