package BitManipulation;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/14.
 */
public class Counting_Bits_338 {
//    public int[] countBits(int num) {
//        int[] dp=new int[num+1];
//        if(num==0) return dp;
//        dp[1]=1;
//        int pre=1;
//        int limit=2;
//        for(int i=2;i<=num;i++){
//            if(i==limit){
//                dp[i]=1;
//                pre=limit;
//                limit*=2;
//            }else{
//                dp[i]=1+dp[i-pre];
//            }
//        }
//        return dp;
//    }

    public int[] countBits(int num){
        int[] f=new int[num+1];
        for(int i=0;i<=num;i++){
            f[i]=f[i>>1]+(i&1);
        }
        return f;
    }

    public static void main(String[] args){
        Counting_Bits_338 s=new Counting_Bits_338();
        System.out.println(Arrays.toString(s.countBits(5)));
    }
}
