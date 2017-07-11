package DP;

import java.util.*;

/**
 * Created by wunengbiao on 2017/6/13.
 */
public class Word_Break_II_140_2 {
//    List<String> res=new ArrayList<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        if(s.length()==0 || wordDict.size()==0) return res;
//        Map<Character,List<String>> map=new HashMap<>();
//        for(String string:wordDict){
//            if(map.containsKey(string.charAt(0))) map.get(string.charAt(0)).add(string);
//            else{
//                map.put(string.charAt(0),new ArrayList<>());
//                map.get(string.charAt(0)).add(string);
//            }
//        }
//        Set<String> set=new HashSet<>(wordDict);
//        helper(s,set,map,"");
//        return res;
//
//    }
//
//    public void helper(String s,Set<String> wordDict,Map<Character,List<String>> map,String word){
//        if(s.length()==0){
//            res.add(word.substring(1));
//            return;
//        }
//        List<String> candidates=map.get(s.charAt(0));
//        if(candidates!=null)
//        for(String candidate:candidates){
//            if(s.length()>=candidate.length() &&wordDict.contains(candidate) &&
//                    s.substring(0,candidate.length()).equals(candidate)){
//                helper(s.substring(candidate.length()),wordDict,map,word+' '+candidate);
//            }
//
//        }
//    }

    Map<Integer,List<String>> dp=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxLenght=-1;
        for(String word:wordDict) maxLenght=Math.max(maxLenght,word.length());
        return helper(s,wordDict,0,maxLenght);
    }

    public List<String> helper(String s,List<String> wordDict,int start,int max){
        List<String> words=new ArrayList<>();
        if(start==s.length()){
            words.add("");
            return words;
        }

        for(int i=start+1;i<=start+max && i<=s.length();i++){
            String temp=s.substring(start,i);
            if(wordDict.contains(temp)){
                List<String> ll;
                if(dp.containsKey(i)) ll=dp.get(i);
                else ll=helper(s,wordDict,i,max);
                for(String ss:ll) words.add(temp+(ss.equals("")?"":" ")+ss);
            }
        }

        dp.put(start,words);
        return words;
    }
    public static void main(String[] args){
        Word_Break_II_140_2 s=new Word_Break_II_140_2();

        //"catsanddog"
        //["cat","cats","and","sand","dog"]
//        String str="catsanddog";
//        String str="a";

//        List<String> wordDict=Arrays.asList("cat","cats","and","sand","dog");
//        List<String> wordDict=Arrays.asList("b");
        String str="bb";
        List<String> wordDict=Arrays.asList("a","b","bbb","bbbb");
        System.out.println(s.wordBreak(str,wordDict));

    }
}
