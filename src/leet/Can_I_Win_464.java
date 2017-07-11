package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/30.
 */
public class Can_I_Win_464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal) return true;
        int sum=((maxChoosableInteger+1)*maxChoosableInteger)>>1;
        if(sum<desiredTotal) return false;
        dp=new int[1<<maxChoosableInteger];
        Arrays.fill(dp,-1);
        return canWin(0,maxChoosableInteger,desiredTotal);
    }

    int [] dp;
    public boolean canWin(int used,int maxChoosableInteger,int desiredTotal){
        if(dp[used]!=-1) return dp[used]>0;
        for(int i=maxChoosableInteger,bits=1<<(maxChoosableInteger-1);i>=1;i--,bits>>=1){
            if((used & bits)!=0) continue;
            if(i>=desiredTotal || !canWin(used | bits,maxChoosableInteger,desiredTotal-i)){
                dp[used]=1;
                return true;
            }
        }
        dp[used]=0;
        return false;
    }

    public static void main(String[] args){
        Can_I_Win_464 s=new Can_I_Win_464();
        System.out.println(s.canIWin(5,15));
    }
}
