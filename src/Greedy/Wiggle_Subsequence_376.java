package Greedy;

/**
 * Created by wunengbiao on 2017/5/14.
 */
public class Wiggle_Subsequence_376 {
    public int wiggleMaxLength(int[] nums) {

        if(nums.length==0) return 0;

        int[] up=new int[nums.length];
        int[] down=new int[nums.length];

        up[0]=1;
        down[0]=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                up[i]=down[i-1]+1;
                down[i]=down[i-1];
            }

            if(nums[i]<nums[i-1]){
                down[i]=up[i-1]+1;
                up[i]=up[i-1];
            }

            if(nums[i]==nums[i-1]){
                down[i]=down[i-1];
                up[i]=up[i-1];
            }
        }

        return Math.max(up[nums.length-1],down[nums.length-1]);

    }

    public static void main(String[] args){
        Wiggle_Subsequence_376 s=new Wiggle_Subsequence_376();
        int[] nums={1,17,5,10,13,15,10,5,16,8};
        System.out.println(s.wiggleMaxLength(nums));
    }
}
