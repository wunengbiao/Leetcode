package Str;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/19.
 */
public class Longest_Palindromic_Substring_5 {
//    public String longestPalindrome(String s) {
//        if(s.length()<=1) return s;
//        int n=s.length();
//
//        int[] dp=new int[n];
//        Arrays.fill(dp,1);
//        for(int i=s.length()-2;i>=0;i--){
//            int right=i+dp[i+1]+1;
//            if(right<n && s.charAt(i)==s.charAt(right)) dp[i]=dp[i+1]+2;
//            else if(i+2<n && s.charAt(i)==s.charAt(i+2)) dp[i]=3;
//            else if(s.charAt(i)==s.charAt(i+1)) dp[i]=2;
//        }
//
//        int max_index=0;
//        for(int i=0;i<n;i++){
//            if(dp[i]>dp[max_index])
//                max_index=i;
//        }
//        return s.substring(max_index,max_index+dp[max_index]);
//    }

    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int max_index=0,max_count=0;
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j) dp[i][j]=true;
                else if(j-i==1 && s.charAt(i)==s.charAt(j)) dp[i][j]=true;
                else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) dp[i][j]=true;

                if(dp[i][j] && j-i+1>max_count){
                    max_index=i;
                    max_count=j-i+1;
                }

            }
        }

        return s.substring(max_index,max_index+max_count);
    }

    public static void main(String[] args){
        Longest_Palindromic_Substring_5 s=new Longest_Palindromic_Substring_5();
        System.out.println(s.longestPalindrome("babad"));
    }
}
