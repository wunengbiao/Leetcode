package lintCode;

/**
 * Created by wunengbiao on 2017/4/4.
 * 有一个消息包含A-Z通过以下规则编码
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 现在给你一个加密过后的消息，问有几种解码的方式
 */
public class Decode {
    public int numDecodings(String s) {

        if(s==null || s.length()==0) return 0;

        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)=='0'?0:1;

        for(int i=2;i<=n;i++){
            int first=Integer.parseInt(s.substring(i-1,i));
            int second=Integer.parseInt(s.substring(i-2,i));

            if(first>0 && first<10) dp[i]+=dp[i-1];
            if(second>9 && second<27) dp[i]+=dp[i-2];

        }
        return dp[n];
    }

//    int count = 0;
//
//    public void backtrack(String s) {
//        if (s.equals("")) {
//            count++;
//            return;
//        }
//        if (s.length()>0) {
//            if(s.length()>1 && s.charAt(1)!='0' && s.charAt(0)!='0')
//                backtrack(s.substring(1));
//            else if(s.length()==1 && s.charAt(0)!='0')
//                backtrack(s.substring(1));
//
//        }
//        if (s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) >= 10 && Integer.parseInt(s.substring(0, 2)) <= 26) {
//            backtrack(s.substring(2));
//        }
//    }

    public static void main(String[] args) {
        Decode s = new Decode();
        System.out.println(s.numDecodings("2226252724242221201918171615141311108787876761721201211012111989898911918293"));
    }
}
