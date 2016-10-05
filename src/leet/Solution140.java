package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2016/9/30.
 */
public class Solution140 {

   void DFS(int pos, List<String>[] dp, List<String> ans, List<String> tmp) {
        if (pos == 0) {
            StringBuilder save = new StringBuilder();
            save.append(tmp.get(tmp.size() - 1));
            for (int i = tmp.size() - 2; i >= 0; i --) {
                save.append(" ");
                save.append(tmp.get(i));
            }
            ans.add(save.toString());
            return;
        }
        for (String word: dp[pos]) {
            tmp.add(word);
            DFS(pos - word.length(), dp, ans, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        List<String>[] dp = new ArrayList[len + 1];
        dp[0] = new ArrayList<>();
        for (int st = 0; st < len; st ++) {
            if (dp[st] != null) {
                for (String word: wordDict) {
                    int ed = st + word.length();
                    if (ed <= len) {
                        if (s.substring(st, ed).equals(word) == true) {
                            if (dp[ed] == null) {
                                dp[ed] = new ArrayList<>();
                            }
                            dp[ed].add(word);
                        }
                    }
                }
            }
        }
        if (dp[len] == null) {
            return ans;
        }
        System.out.println(dp);
        List<String> tmp = new ArrayList<>();
        DFS(len, dp, ans, tmp);
        return ans;
    }

    public static void main(String[] args){
        Solution140 s=new Solution140();

        List<String> ret=new ArrayList<>();
        Set<String> wordDict=new HashSet<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");
        String str="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

//        String str="catsanddog";
//        wordDict.add("cat");
//        wordDict.add("cats");
//        wordDict.add("and");
//        wordDict.add("sand");
//        wordDict.add("dog");
        ret=s.wordBreak(str,wordDict);
        System.out.println(ret);
    }
}
