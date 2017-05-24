package TYVJ;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/17.
 */
public class P1014 {
    public int solve(int[] arr){
        if(arr.length<3) return 0;

        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for(int len=0;len<n;len++){
            for(int i=0;i<n-len;i++){
                int j=len+i;
                for(int k=i;k<=j;k++){

                    int l = i > 0 ? arr[i-1] : 1;
                    int r = j < n-1 ? arr[j+1] : 1;
                    int left = k - 1 >= i ? dp[i][k-1] : 0;
                    int right = k + 1 <= j ? dp[k+1][j] : 0;

                    dp[i][j]=Math.min(dp[i][j],arr[k]*r*l+left+right);
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[1][n-2];

    }

    public static void main(String[] args){
        P1014 s=new P1014();
        int[] arr={10,1,50,20,5};
        System.out.println(s.solve(arr));
    }
}
