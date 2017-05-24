package NetEase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/14.
 */
public class Pile_Up_Bricks {
    public int solve(int[] arr){
        int sum=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            max=Math.max(max,arr[i]);
        }
        int[][] dp=new int[arr.length][sum+1+max];
        for(int i=0;i<sum+max+1;i++){
            dp[0][i]=-11111111;
        }
        dp[0][0]=0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j+arr[i]]);
                if(j>=arr[i]) dp[i][j]=Math.max(dp[i][j],dp[i-1][j-arr[i]]+arr[i]);
                else dp[i][j]=Math.max(dp[i][j],dp[i-1][arr[i]-j]+j);
                System.out.println(i+":"+j+":"+dp[i][j]);
            }
        }

        if(dp[arr.length-1][0]>0) return dp[arr.length-1][0];
        return -1;


    }

    public static void main(String[] args){
        Pile_Up_Bricks s=new Pile_Up_Bricks();
        Scanner in=new Scanner(System.in);

        int[] arr;
        while(in.hasNext()){
            int n=Integer.parseInt(in.nextLine());
            arr=new int[n+1];
            for(int i=1;i<=n;i++){
                arr[i]=in.nextInt();
            }
            System.out.println(s.solve(arr));
        }
    }
}
