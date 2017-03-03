package leet;

/**
 * Created by wunengbiao on 2017/2/15.
 */
public class Solution413 {

    public int numberOfArithmeticSlices(int[] A) {

        int N=A.length;
        if(N<3) return 0;

        int[] dp=new int[N+1];
        dp[N]=0;
        dp[N-1]=0;
        dp[N-2]=0;
        int d=A[N-1]-A[N-2];
        int last=N;

        for(int i=A.length-3;i>=0;i--){
            if(A[i+1]-A[i]==d){
                dp[i]=dp[i+1]+last-i-2;
            }else {
                dp[i]=dp[i+1];
                d=A[i+1]-A[i];
                last=i+2;
            }
        }
        return dp[0];
    }

    public static void main(String[] args){
        Solution413 s=new Solution413();
        int[] test={2,4,6,8,10};
        System.out.println(s.numberOfArithmeticSlices(test));
    }

}
