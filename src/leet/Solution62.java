package leet;

/**
 * Created by wunengbiao on 2016/10/2.
 */
public class Solution62 {

//    int count=0;
//    public int uniquePaths(int m, int n) {
//        backstrack(1,1,m,n);
//        return count;
//    }
//
//    void backstrack(int m,int n,int row,int col){
//        if(m==row && n==col){
//            count++;
//            return;
//        }else{
//            if(m+1<=row)
//            backstrack(m+1,n,row,col);
//            if(n+1<=col)
//            backstrack(m,n+1,row,col);
//        }
//
//    }

    public int uniquePaths(int m,int n){
        if(m==1 || n==1)
            return 1;

        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int j=0;j<n;j++) dp[0][j]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args){
        Solution62 s=new Solution62();
        int count=s.uniquePaths(23,11);
        System.out.println(count);
    }
}
