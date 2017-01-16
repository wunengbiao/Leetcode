package leet;

import java.util.*;
import java.util.stream.Collector;

/**
 * Created by wunengbiao on 2016/12/19.
 */
public class Solution126 {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String,Integer> distance=new HashMap<>();
        Map<String,List<String>> nodeNeighbourNodes=new HashMap<>();
        List<String> solution=new ArrayList<>();
        wordList.add(endWord);

        bfs(beginWord,endWord,wordList,distance,nodeNeighbourNodes);

        System.out.println(distance);
        dfs(beginWord,endWord,wordList,distance,nodeNeighbourNodes,solution);

        return result;

    }

    public void dfs(String beginWord,String endWord,Set<String> wordList,Map<String,Integer> distance,Map<String,List<String>>nodeNeighbours,List<String> solution){
        solution.add(beginWord);
        if(beginWord.equals(endWord)){
            result.add(new ArrayList<>(solution));
        }else{
            for(String next:nodeNeighbours.get(beginWord)){
                if(distance.get(next)==distance.get(beginWord)+1){
                    dfs(next,endWord,wordList,distance,nodeNeighbours,solution);
                }
            }
        }
        solution.remove(solution.size()-1);
    }

    public void bfs(String beginWord,String endWord,Set<String> wordList,Map<String,Integer> distance,Map<String,List<String>> nodeNeighbours){

        for(String str:wordList)
            nodeNeighbours.put(str,new ArrayList<String>());
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord,0);

        while(!queue.isEmpty()){

            int count=queue.size();
            boolean foundEnd=false;

            for(int i=0;i<count;i++){
                String cur=queue.poll();
                int curDistance=distance.get(cur);
                List<String> neighbours=getNeighbors(cur,wordList);
                for(String neighbour:neighbours){
                    nodeNeighbours.get(cur).add(neighbour);
                    if(!distance.containsKey(neighbour)){
                        distance.put(neighbour,curDistance+1);
                        if(endWord.equals(neighbour))
                            foundEnd=true;
                        else
                            queue.offer(neighbour);
                    }
                }
            }
            if(foundEnd) break;

        }
    }



//    public List<String> getNeihbours(String node,Set<String> wordList){
//        List<String> neighbours=new ArrayList<>();
//
//        char chs[]=node.toCharArray();
//
//        for(int i=0;i<node.length();i++){
//            char[] temp=chs;
//            for(char ch='a';ch<='z';ch++){
//                temp[i]=ch;
//
//                String key=new String(temp);
//                if(wordList.contains(key))
//                    neighbours.add(key);
//            }
//        }
//        return neighbours;
//    }
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
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

        Solution126 s=new Solution126();

        List<String> neighbours=s.getNeighbors("hit",wordList);
        System.out.println(neighbours);
        List<List<String>>res=s.findLadders(beginWord,endWord,wordList);
        System.out.println(res);
    }



}
