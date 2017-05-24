package lintCode;

/**
 * Created by wunengbiao on 2017/4/5.
 */
public class JumpII {
    public int jump(int[] A) {
        int[] dp=new int[A.length];
        for(int i=0;i<A.length;i++) dp[i]=Integer.MAX_VALUE;
        dp[0]=0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<=Math.min(A.length-1,i+A[i]);j++){
                dp[j]=Math.min(dp[j],dp[i]+1);
            }
        }
        return dp[A.length-1];

    }

    public static void main(String[] args){
        JumpII s=new JumpII();
//        int[] nums={3,2,1,0,4};
        int[] nums={2,3,1,1,4};
        System.out.println(s.jump(nums));
    }
}
