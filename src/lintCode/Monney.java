package lintCode;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/4.
 * 给出一个都是正整数的数组 nums，其中没有重复的数。从中找出所有的和为 target 的组合个数。
 */
public class Monney {

//    public int backPackVI(int[] nums, int target) {
//        int[][] dp=new int[nums.length][target+1];
//
//        Arrays.sort(nums);
//        for(int i=0;i<=target;i++){
//            if(i%nums[0]==0) dp[0][i]=1;
//        }
//
//        for(int i=1;i<nums.length;i++){
//            for(int j=0;j<=target;j++){
//                if(j>=nums[i]){
//                    dp[i][j]=dp[i][j-nums[i]]+dp[i-1][j];
//                }else{
//                    dp[i][j]=dp[i-1][j];
//                }
//            }
//        }
//
//        return dp[nums.length-1][target];
//    }
//    public int backPackVI(int[] nums, int target) {
//        Arrays.sort(nums);
//        backtrack(nums,target);
//        return res;
//
//    }
//
//    int res=0;
//    public void backtrack(int[] nums,int targrt){
//        if(targrt==0){
//            res+=1;
//            return;
//        }
//
//        for(int num:nums){
//            if(targrt>=num)
//                backPackVI(nums,targrt-num);
//            else{
//                break;
//            }
//        }
//    }
public int backPackVI(int[] nums, int target) {
    int[] dp=new int[target+1];

    dp[0]=1;
    for(int i=1;i<=target;i++){
        for(int num:nums){
            if(i>=num) dp[i]+=dp[i-num];
        }
    }
    return dp[target];
}

    public static void main(String[] args){
        Monney monney=new Monney();
        int[] nums={37,40,28,39,36,20,23,25,31,1,2,3,4};
        System.out.println(monney.backPackVI(nums,31));
    }
}
