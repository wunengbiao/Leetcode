package JD;

public class GoUpstairs {
    public static final int MOD=1000000007;
    public int countWays(int n) {
        if(n==1) return 0;
        int[] dp=new int[n+1];
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%MOD;
        }
        return dp[n];
    }
}