package DP;

import java.math.BigInteger;

/**
 * Created by wunengbiao on 2017/2/25.
 */
public class Unique_Binary_Search_Trees_96 {

    public int numTrees(int n) {

        BigInteger N=new BigInteger(String.valueOf(n+1));
        BigInteger numerator=factorial(n);
        BigInteger denominator=factorial(2*n);
        return denominator.divide(numerator).divide(N).divide(numerator).intValue();

    }

    public BigInteger factorial(int n){
        BigInteger res=new BigInteger(String.valueOf(1));
        for(int i=1;i<=n;i++){
            res=res.multiply(new BigInteger(String.valueOf(i)));
        }

        return res;
    }

    public static void main(String[] args){
        Unique_Binary_Search_Trees_96 s=new Unique_Binary_Search_Trees_96();
        System.out.println(s.numTrees(3));
    }
}
