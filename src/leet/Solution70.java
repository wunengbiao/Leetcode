package leet;

import ChinaMobile.Solution;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/1/8.
 */
public class Solution70 {
    public int climbStairs(int n) {
        if(n<4) return n;
        int[] dp=new int[n+1];

        int before=2;
        int after=3;
        for(int i=4;i<=n;i++){
            int temp=after;
            after=before+after;
            before=temp;
        }

        return after;
    }
    public static void main(String[] args){
        Solution70 s=new Solution70();
        int res=s.climbStairs(4);
        System.out.println(res);
    }
}
