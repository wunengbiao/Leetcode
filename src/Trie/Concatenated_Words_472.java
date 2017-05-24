package Trie;

import java.util.*;

/**
 * Created by wunengbiao on 2017/5/15.
 */
public class Concatenated_Words_472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res=new ArrayList<>();
        Set<String> set=new HashSet<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        for(int i=0;i<words.length;i++){
            if(canForm(words[i],set)) res.add(words[i]);
            set.add(words[i]);
        }

        return res;

    }

    public boolean canForm(String word,Set<String> words){

        if(words.isEmpty()) return false;
        boolean[] dp=new boolean[word.length()+1];
        dp[0]=true;
        for(int i=1;i<=word.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]==false) continue;
                if(words.contains(word.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
