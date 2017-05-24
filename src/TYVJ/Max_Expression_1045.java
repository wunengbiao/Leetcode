package TYVJ;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/16.
 */
public class Max_Expression_1045 {
    public int solve(int[] arr,int K){
        int n=arr.length;
        int[] sum=new int[n];
        for(int i=1;i<n;i++){
            sum[i]=sum[i-1]+arr[i];
        }
        int[][] dp=new int[n][n];

       for(int i=1;i<n;i++){
           dp[i][0] = dp[i - 1][0] + arr[i];
           for(int j=1;j<i && j<=K;j++){
               for(int k=1;k!=i;k++){
                   if(dp[k][j-1]*(sum[i]-sum[k])>dp[i][j])
                       dp[i][j]=dp[k][j-1]*(sum[i]-sum[k]);

                   System.out.println(k+"-("+i+":"+j+")="+dp[i][j]);
               }

           }
       }

       for(int i=0;i<n;i++){
           System.out.println(Arrays.toString(dp[i]));
       }

       return dp[n-1][K];
    }

    public static void main(String[] args){
        Max_Expression_1045 s=new Max_Expression_1045();
        int[] arr={0,1,2,3,4,5};
        System.out.println(s.solve(arr,2));
    }
}
