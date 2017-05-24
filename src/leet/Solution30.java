package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2016/10/21.
 */
public class Solution30 {

   public List<Integer> findSubstring(String s, String[] words) {

       List<Integer> res=new ArrayList<>();

       int n=s.length(),m=words.length,k;
       if(n==0 || m==0 || (k=words[0].length())==0) return res;

       HashMap<String,Integer> wDict=new HashMap<>();

       for(String word:words){
           wDict.put(word,wDict.getOrDefault(word,0)+1);
       }


       int i=0,j,start,x,wordsLen=m*k;

       HashMap<String,Integer> curDict=new HashMap<>();
       String temp,test;

       for(i=0;i<k;i++){
           curDict.clear();
           start=i;

           if(start+wordsLen>n) return res;

           for(j=i;j+k<=n;j+=k){
               test=s.substring(j,j+k);

               if(wDict.containsKey(test)){
                   if(!curDict.containsKey(test)) {
                       curDict.put(test, 1);
                       start = checkFound(res, start, wordsLen, j, k, curDict, s);
                       continue;
                   }

                   x=curDict.get(test);
                   if(x<wDict.get(test)){
                       curDict.put(test,x+1);
                       start=checkFound(res,start,wordsLen,j,k,curDict,s);
                       continue;
                   }

                   while(!(temp=s.substring(start,start+k)).equals(test)){
                       decreaseCount(curDict,temp);
                       start+=k;
                   }

                   start+=k;
                   if(start+wordsLen>n)
                       break;
                   continue;
               }

               start=j+k;
               if(start+wordsLen>n)
                   break;;
               curDict.clear();

           }
       }

       return res;
   }

   public int checkFound(List<Integer> res, int start, int wordsLen, int j, int k,
                         HashMap<String, Integer> curDict, String s){
       if(start+wordsLen==j+k){
           res.add(start);
           decreaseCount(curDict,s.substring(start,start+k));
           return start+k;
       }
       return start;
   }

   public void decreaseCount(HashMap<String,Integer> curDict,String key){
       int x=curDict.get(key);
       if(x==1)
           curDict.remove(key);
       else{
           curDict.put(key,x-1);
       }
   }


    public static void main(String[] args){
        Solution30 s=new Solution30();
        String[] words={"foo","bar","the"};

        List<Integer> result=s.findSubstring("barfoofodasssssssssssssssdasdassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssobarthefoobarman",words);
        System.out.println(result);
    }
}
