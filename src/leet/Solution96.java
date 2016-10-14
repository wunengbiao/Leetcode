package leet;

import SouHu.Solution;

import java.math.BigInteger;

/**
 * Created by wunengbiao on 2016/10/2.
 */
public class Solution96 {
     public int numTrees(int n) {
         if(n==0) return 0;
         BigInteger bedivider=new BigInteger(String.valueOf(n+1)).multiply(factorial(n)).multiply(factorial(n));
         int i=n*2;
         BigInteger divider=factorial(i);
         BigInteger result=divider.divide(bedivider);
         return result.intValue();
    }

    BigInteger factorial(int n){
        if(n<=1) return new BigInteger("1");
        else return new BigInteger(String.valueOf(n)).multiply(new BigInteger(String.valueOf(factorial(n-1))));
    }

    public static void main(String[] args){
        Solution96 s=new Solution96();
        int ret=s.numTrees(19);
        System.out.println(ret);
    }
}
