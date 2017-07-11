package leet;

/**
 * Created by wunengbiao on 2017/5/29.
 */
public class Guess_Number_Higher_or_Lower_II_375 {
    /*public int getMoneyAmount(int n) {
        if(n==1){
            return 0;
        }

        int[][] dp=new int[n+1][n+1];
       for (int i=1;i<=n;i++){
           for(int j=i;j<=n;j++){
               dp[i][j]=Integer.MAX_VALUE;
               for(int k=i;k<=j;k++){
                   dp[i][j]=Math.min(dp[i][j],k+Math.max(k-1>=i?dp[i][k-1]:0,j>=k+1?dp[k+1][j]:0));
               }
           }
       }
        return dp[1][n];
    }*/

    public int getMoneyAmount(int n) {
        int[][] table=new int[n+1][n+1];
        return dfs(table,1,n);
    }

    int dfs(int[][] t,int s,int e){
        if(s>=e) return 0;
        if(t[s][e]!=0) return t[s][e];
        int res=Integer.MAX_VALUE;
        for(int x=s;x<=e;x++){
            int tmp=x+Math.max(dfs(t,s,x-1),dfs(t,x+1,e));
            res=Math.min(res,tmp);
        }
        return res;
    }

    public static void main(String[] args){
        Guess_Number_Higher_or_Lower_II_375 s=new Guess_Number_Higher_or_Lower_II_375();
        System.out.println(s.getMoneyAmount(10));
    }
}
