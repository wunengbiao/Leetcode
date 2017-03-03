package DP;

/**
 * Created by wunengbiao on 2017/2/26.
 */
public class Interleaving_String_97 {

//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()==0) return s2.equals(s3);
//        if(s2.length()==0) return s1.equals(s3);
//        if(s3.length()==0) return s1.length()+s2.length()==0;
//
//        if(s1.charAt(0)==s3.charAt(0) && s2.charAt(0)==s3.charAt(0)){
//            return isInterleave(s1.substring(1),s2,s3.substring(1))
//                    || isInterleave(s1,s2.substring(1),s3.substring(1));
//        }else if(s1.charAt(0)==s3.charAt(0)){
//            return isInterleave(s1.substring(1),s2,s3.substring(1));
//        }else if(s2.charAt(0)==s3.charAt(0)){
//            return isInterleave(s1,s2.substring(1),s3.substring(1));
//        }else{
//            return false;
//        }
//    }
public boolean isInterleave(String s1, String s2, String s3) {
    if(s3.length()!=s1.length()+s2.length()) return false;

    boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
    dp[0][0]=true;
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

    for(int i=1;i<=s1.length();i++){
        for(int j=1;j<=s2.length();j++){
            int k=i+j;
            if(s1.charAt(i-1)==s3.charAt(k-1)) dp[i][j]=(dp[i][j] || dp[i-1][j]);
            if(s2.charAt(j-1)==s3.charAt(k-1)) dp[i][j]=(dp[i][j] || dp[i][j-1]);
        }
    }


    return dp[s1.length()][s2.length()];
}

    public static void main(String[] args){
        Interleaving_String_97 s=new Interleaving_String_97();
        /*
            s1 = "aabcc",
            s2 = "dbbca",

            When s3 = "aadbbcbcac", return true.
            When s3 = "aadbbbaccc", return false.
         */

//        String s1="aabccabc";
//        String s2="dbbabc";
//        String s3="aabdbbccababcc";

//        String s1="aabcc";
//        String s2="dbbca";
//        String s3="aadbbcbcac";

//        String s1="aabc";
//        String s2="abad";
//        String s3="aabcabad";

        String s1="bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2="babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3="babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
//        String s1="a";
//        String s2="b";
//        String s3="ab";

        System.out.println(s.isInterleave(s1,s2,s3));

    }
}
