package DP;

/**
 * Created by wunengbiao on 2017/2/27.
 */
public class Palindrome_Partitioning_II_132 {

    public int minCut(String s) {
        if(s==null) return 0;
        int n=s.length();
        int[] f=new int[n+1];
        for(int i=0;i<=n;i++) f[i]=n-1-i;

        boolean[][] dp=new boolean[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) &&(j-i<2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    f[i]=Math.min(f[i],f[j+1]+1);
                }

            }
        }
        return f[0];
    }

    public static void main(String[] args){
        Palindrome_Partitioning_II_132 s=new Palindrome_Partitioning_II_132();
        System.out.println(s.minCut("abb"));
    }
}
