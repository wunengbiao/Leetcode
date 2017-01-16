package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2016/12/29.
 */
public class Solution126_3 {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {


        Map<String,List<String>> table=new HashMap<>();

        List<String> neighbours=new ArrayList<>();
        for(String item:wordList){
            if(oneDiff(item,beginWord))
                neighbours.add(item);
        }
        table.put(beginWord,new ArrayList<>(neighbours));

        for(String key:wordList){
            neighbours.clear();
            for(String neighbour:wordList){
                if(oneDiff(key,neighbour))
                    neighbours.add(neighbour);
            }
            table.put(key,new ArrayList<>(neighbours));
        }

        Set<String> path=new LinkedHashSet<>();
        path.add(beginWord);

        bfs(beginWord,endWord,table,path);

        return result;

    }

    int min=Integer.MAX_VALUE;
    public void bfs(String beginWod,String endWord,Map<String,List<String>> table,Set<String> path){
        if(oneDiff(beginWod,endWord)){
            if(path.size()<min){
                if(path.size()<min-1){
                    result.clear();
                    min=path.size()+1;
                }
                path.add(endWord);
                result.add(new ArrayList<>(path));
                path.remove(endWord);

            }

            return;
        }

        List<String> neighbours=table.get(beginWod);
        if(neighbours.size()==0) return;
        for(String neighbour:neighbours){
            if(path.size()<=min-1&& !path.contains(neighbour)){
                path.add(neighbour);
                bfs(neighbour,endWord,table,path);
                path.remove(neighbour);
            }
        }
    }

    boolean oneDiff(String s1,String s2){
        int n=s1.length();
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();

        int count=0;
        for(int i=0;i<n;i++){
            if(c1[i]==c2[i])
                continue;
            else count++;
        }

        if(count==1) return true;
        return false;
    }
    public static void main(String[] args){
        String beginWord="hit";
        String endWord="cog";

        Set<String> wordList=new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
//        String beginWord="hot";
//        String endWord="dog";
//
//        Set<String> wordList=new HashSet<>();
//        wordList.add("hot");
//        wordList.add("dog");
//        wordList.add("cog");
//        wordList.add("pot");
//        wordList.add("dot");



        Solution126_3 s=new Solution126_3();
        List<List<String>>res=s.findLadders(beginWord,endWord,wordList);
        System.out.println(res);
    }
}
