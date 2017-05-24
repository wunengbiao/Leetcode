package TYVJ;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/17.
 */
public class P1088 {
    public int solve(int[] array,int l,int r,int[][] dp,int time){
        if(l>r) return 0;
        if(dp[l][r]!=0){
            return dp[l][r];
        }else{
            int tempMax=0;
            tempMax=Math.max(solve(array,l+1,r,dp,time+1)+array[l]*time,tempMax);
            tempMax=Math.max(solve(array,l,r-1,dp,time+1)+array[r]*time,tempMax);

            dp[l][r]=tempMax;
            return tempMax;
        }
    }

    public static void main(String[] args){
        P1088 s=new P1088();
        Scanner in=new Scanner(System.in);

        int n=Integer.parseInt(in.nextLine());
        int[][] dp=new int[n][n];
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=Integer.parseInt(in.nextLine());
        }

        System.out.println(s.solve(array,0,n-1,dp,1));
    }
}
