package leet;

/**
 * Created by wunengbiao on 2017/1/17.
 */
public class Solution264 {

    public int nthUglyNumber(int n) {

        int index_2=0,index_3=0,index_5=0;
        int val_2=2,val_3=3,val_5=5;
        int[] dp=new int[n];
        dp[0]=1;

        for(int i=1;i<n;i++){

            int val=Math.min(Math.min(val_2,val_3),val_5);
            if(val==val_2){
                dp[i]=val_2;
                index_2++;
                val_2=dp[index_2]*2;
            }

            if(val==val_3){
                dp[i]=val_3;
                index_3++;
                val_3=dp[index_3]*3;
            }

            if(val==val_5){
                dp[i]=val_5;
                index_5++;
                val_5=dp[index_5]*5;
            }

        }

        return dp[n-1];

    }

    public static void main(String[] args){
        Solution264 s=new Solution264();
        System.out.println(s.nthUglyNumber(13));
    }
}
