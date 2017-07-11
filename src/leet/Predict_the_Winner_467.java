package leet;

/**
 * Created by wunengbiao on 2017/5/30.
 */
public class Predict_the_Winner_467 {
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        Integer[][] mem=new Integer[n][n];
        int count=solve(nums,0,n-1,mem);
        return count>=0;
    }

//    public int solve(int i,int j,int[] sum){
//        if(i==j) return sum[j]-sum[i-1];
//        else return sum[j]-sum[i-1]-Math.min(solve(i+1,j,sum),solve(i,j-1,sum));
//    }

    public int solve(int[] nums,int i,int j,Integer[][] mem){
        if(mem[i][j]==null)
            mem[i][j]=i==j?nums[i]:Math.max(nums[i]-solve(nums,i+1,j,mem),nums[j]-solve(nums,i,j-1,mem));
        return mem[i][j];
    }

    public static void main(String[] args){
        Predict_the_Winner_467 s=new Predict_the_Winner_467();
        int[] nums={1,5,2};
        System.out.println(s.PredictTheWinner(nums));
    }
}
