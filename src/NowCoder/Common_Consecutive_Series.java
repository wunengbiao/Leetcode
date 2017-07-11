package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/5.
 */
public class Common_Consecutive_Series {
    public int solve(String s1,String s2){
        int max=0;

        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) && j>=i){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }

                if(s1.charAt(i-1)==s2.charAt(j-1) && j<=i){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        Common_Consecutive_Series s=new Common_Consecutive_Series();
        Scanner in=new Scanner(System.in);
        String s1=in.nextLine();
        String s2=in.nextLine();
        System.out.println(s.solve(s1,s2));
    }
}
