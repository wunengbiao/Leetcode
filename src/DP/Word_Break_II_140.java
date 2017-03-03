package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wunengbiao on 2017/2/28.
 */
public class Word_Break_II_140 {
//    List<String> result=new ArrayList<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        bfs(s,wordDict,"");
//        return result;
//    }
//
//    public void bfs(String s,List<String> wordDict,String temp){
//        if(s.equals("")){
//            result.add(temp.substring(0,temp.length()-1));
//            return;
//        }
//
//        for(String str:wordDict){
//            if(s.length()>=str.length() && s.substring(0,str.length()).equals(str)){
//                bfs(s.substring(str.length()),wordDict,temp+str+" ");
//            }
//        }
//    }

    HashMap<Integer,List<String>> dp=new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxLength=-1;
        for(String ss:wordDict) maxLength=Math.max(maxLength,ss.length());
        return addSpaces(s,wordDict,0,maxLength);
    }



    private List<String> addSpaces(String s,List<String> wordDict,int start,int max){
        List<String> words=new ArrayList<>();
        if(start==s.length()){
            words.add("");
            return words;
        }

        for(int i=start+1;i<=max+start&& i<=s.length();i++){
            String temp=s.substring(start,i);
            if(wordDict.contains(temp)){
                List<String> ll;
                if(dp.containsKey(i)) ll=dp.get(i);
                else ll=addSpaces(s,wordDict,i,max);
                for(String ss:ll) words.add(temp+(ss.equals("")?"":" ")+ss);
            }
        }

        dp.put(start,words);
        return words;
    }

    public static void main(String[] args){

        Word_Break_II_140 solution=new Word_Break_II_140();
//        String s="catsanddog";
//        List<String> wordDict= Arrays.asList("cat","cats","and","sand","dog");

        String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict= Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(solution.wordBreak(s,wordDict));

    }

}
