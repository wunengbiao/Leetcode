package TYVJ;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/18.
 */
public class P1008 {

    public int solve(int m,int n){
        int[][] dp=new int[m+1][n+2];
        dp[0][1]=1;
        dp[0][n+1]=1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
            }

            dp[i][0]=dp[i][n];
            dp[i][n+1]=dp[i][1];
        }

        return dp[m][1];
    }

    public static void main(String[] args){
        P1008 s=new P1008();
        Scanner in=new Scanner(System.in);

        String[] line=in.nextLine().split(" ");

        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);

        System.out.println(s.solve(m,n));
    }
}
