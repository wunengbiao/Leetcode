package Str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/5/10.
 */
public class Palindrome_Pairs_336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<>();
        if (words == null && words.length < 2) return res;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }


        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){
                String before=words[i].substring(0,j);
                String after=words[i].substring(j);

                if(isPalindrome(before)){
                    String key=new StringBuilder(after).reverse().toString();

                    if(map.containsKey(key) && map.get(key)!=i){
                        List<Integer> list=new ArrayList<>();
                        list.add(map.get(key));
                        list.add(i);
                        res.add(list);
                    }
                }

                if(isPalindrome(after)){
                    String key=new StringBuilder(before).reverse().toString();

                    if(map.containsKey(key) && map.get(key)!=i && after.length()!=0){
                        List<Integer> list=new ArrayList<>();
                        list.add(i);
                        list.add(map.get(key));
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        Palindrome_Pairs_336 s=new Palindrome_Pairs_336();
        String[] words={"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(s.palindromePairs(words));
    }
}
