package leet;

import ChinaMobile.Solution;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/2/12.
 */
public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index=new int[primes.length];
        int[] cur=new int[primes.length];
        for(int i=0;i<primes.length;i++){
            cur[i]=primes[i];
        }
        int[] dp=new int[n];
        dp[0]=1;

        for(int i=1;i<n;i++){
//            System.out.println("Cur:"+Arrays.toString(cur));
//            System.out.println("Index:"+Arrays.toString(index));
            int min=minIndex(cur);
            dp[i]=cur[min];
            while(cur[min]<=dp[i-1]){
                index[min]++;
                cur[min]=dp[index[min]]*primes[min];
            }
        }
        return dp[n-1];
    }

    public int minIndex(int[] primers){
        int index=0;
        for(int i=1;i<primers.length;i++){
            if(primers[i]<primers[index])
                index=i;
        }
        return index;
    }

    public static void main(String[] args){
        Solution313 s=new Solution313();
        int[] primers={2,7,13,19};
        for(int i=0;i<12;i++){
            System.out.println("The "+(i+1)+"th primer is:"+s.nthSuperUglyNumber(i+1,primers));
        }
    }
}
