package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wunengbiao on 2017/3/19.
 */
public class Group_Anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> map=new HashMap<>();
        for(String s:strs){
            int hash=hashcode(s);
            if(map.containsKey(hash))
                map.get(hash).add(s);
            else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(hash,list);
            }
        }

        List<List<String>> res=new ArrayList<>();
        for(Integer key:map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }

    public int hashcode(String s){
        if(s.equals("")) return 1;
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        int key=1;
        for(char c:s.toCharArray()){
            key*=prime[c-'a'];
        }
        return key;
    }

    public static void main(String[] args){

        String[] test={"tho","tin","erg","end","pug","ton","alb","mes","job","ads","soy","toe","tap","sen","ape","led","rig","rig","con","wac","gog","zen","hay","lie","pay","kid","oaf","arc","hay","vet","sat","gap","hop","ben","gem","dem","pie","eco","cub","coy","pep","wot","wee"};
        String[] test2={"run","had","lot","kim","fat","net","fin","rca","chi","lei","lox","iva","liz","hug","hot","irk","lap","tan","tux","yuk","hep","map","ran","ell","kit","put","non","aol","add","lad","she","job","mes","pen","vic","fag","bud","ken","nod","jam","coy","hui","sue","nap","ton","coy","rut","fit","cut","eta","our","oho","zip"};
        Group_Anagrams_49 g=new Group_Anagrams_49();
        System.out.println(g.groupAnagrams(test2));
        System.out.println(g.hashcode("fin"));
        System.out.println(g.hashcode("ell"));
        System.out.println(' '-'a');
    }
}
