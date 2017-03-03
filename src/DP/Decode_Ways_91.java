package DP;

/**
 * Created by wunengbiao on 2017/2/24.
 */
public class Decode_Ways_91 {
    public int numDecodings(String s) {
        if(s.length()==0 || s==null) return 0;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=s.charAt(0)!='0'?1:0;

        for(int i=2;i<=s.length();i++){
            int first=Integer.valueOf(s.substring(i-1,i));
            int second=Integer.valueOf(s.substring(i-2,i));

            if(first>0 && first<10) dp[i]+=dp[i-1];
            if(second>9 && second<27) dp[i]+=dp[i-2];
        }
        return dp[s.length()];
    }

    public static void main(String[] args){
        Decode_Ways_91 s=new Decode_Ways_91();
        System.out.println(s.numDecodings("10"));
    }
}
