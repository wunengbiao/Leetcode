package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2017/2/28.
 */
public class Word_Break_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int m=wordDict.size();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            if(dp[n]) break;
            for(int j=0;j<m;j++){
                if(dp[n]) break;
                int k=wordDict.get(j).length();
                if(n-i+1>=k)
                if(s.substring(i-1,i+k-1).equals(wordDict.get(j)))
                    dp[i-1+k]=dp[i-1]||dp[i-1+k];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Word_Break_139 solution=new Word_Break_139();
        String s="leetcode";
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        String s1="bb";
        List<String> wordDict1= Arrays.asList("a","b","bbb","bbbb");

        String s2="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict2= Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        String s3="aaaaaaa";
        List<String> wordDict3=Arrays.asList("aaaa","aaa");

        System.out.println(solution.wordBreak(s3,wordDict3));
    }
}
