package lintCode;

/**
 * Created by wunengbiao on 2017/4/6.
 */
public class String_Interleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length();
        int n=s2.length();
        if(m==0) return s2.equals(s3);
        if(n==0) return s1.equals(s3);
        if(m+n!=s3.length()) return false;
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
//        for(int i=1;i<=n;i++){
//            dp[0][i]=s2.charAt(i-1)==s3.charAt(i-1);
//        }
//        for(int i=1;i<=m;i++){
//            dp[0][i]=s1.charAt(i-1)==s2.charAt(i-1);
//        }
        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0]=true;
            else break;
        }

        for(int i=1;i<=s2.length();i++){
            if(s2.charAt(i-1)==s3.charAt(i-1))
                dp[0][i]=true;
            else
                break;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s3.charAt(i+j-1))
                    dp[i][j]=(dp[i-1][j] || dp[i][j]);
                if(s2.charAt(j-1)==s3.charAt(i+j-1))
                    dp[i][j]=(dp[i][j-1] || dp[i][j]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args){
        String_Interleave s=new String_Interleave();
        String s1 = "a";
        String s2 = "aa";
//        String s1 = "aabcc";
//        String s2 = "dbbca";

        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";

        System.out.println(s.isInterleave(s1,s2,s3));
        System.out.println(s.isInterleave(s1,s2,"aaa"));
    }
}
