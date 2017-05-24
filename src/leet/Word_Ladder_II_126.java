package leet;

import java.util.*;

/**
 * Created by wunengbiao on 2017/5/10.
 */
public class Word_Ladder_II_126 {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String,Integer> distance=new HashMap<>();
        Map<String,List<String>> nodeNeighbours=new HashMap<>();
        List<String> solution=new ArrayList<>();
        wordList.add(endWord);
        bfs(beginWord,endWord,wordList,distance,nodeNeighbours);
        dfs(beginWord,endWord,wordList,distance,nodeNeighbours,solution);
        return result;
    }

    public void dfs(String beginWord,String endWord,List<String> wordList,Map<String,Integer> distances,Map<String,List<String>> nodeNeighbors,List<String> solution){
        solution.add(beginWord);
        if(beginWord.equals(endWord)){
            result.add(new ArrayList<>(solution));
        }else{
            for(String next:nodeNeighbors.get(beginWord)){
                if(distances.get(next)==distances.get(beginWord)+1)
                    dfs(next,endWord,wordList,distances,nodeNeighbors,solution);

            }
        }
        solution.remove(solution.size()-1);
    }

    public void bfs(String beginword,String endWord,List<String> wordList,Map<String,Integer> distances,Map<String,List<String>> nodeNeighbors){
        nodeNeighbors.put(beginword,new ArrayList<>());
        for(String s:wordList){
            nodeNeighbors.put(s,new ArrayList<>());
        }

        Queue<String> queue=new LinkedList<>();
        queue.offer(beginword);
        distances.put(beginword,0);

        while(!queue.isEmpty()){
            int count=queue.size();
            boolean findEnd=false;

            for(int i=0;i<count;i++){
                String cur=queue.poll();
                int curDistance=distances.get(cur);

                List<String> neighbours=getNeihbours(cur,wordList);

                for(String neighbour:neighbours){
                    nodeNeighbors.get(cur).add(neighbour);
                    if(!distances.containsKey(neighbour)){
                        distances.put(neighbour,curDistance+1);

                        if(endWord.equals(neighbour))
                            findEnd=true;
                        else
                            queue.offer(neighbour);
                    }
                }
            }

            if(findEnd) break;
        }


    }

    public ArrayList<String> getNeihbours(String node,List<String> dict){
        ArrayList<String> res=new ArrayList<>();
        char[] chs=node.toCharArray();

        for(char ch='a';ch<'z';ch++){
            for(int i=0;i<chs.length;i++){
                if(chs[i]==ch) continue;
                char old=chs[i];
                chs[i]=ch;

                if(dict.contains(String.valueOf(chs))) res.add(String.valueOf(chs));
                chs[i]=old;
            }
        }

        return res;
    }

    public static void main(String[] args){
        String beginWord="hit";
        String endWord="cog";

        List<String> wordList=new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");

        Word_Ladder_II_126 s=new Word_Ladder_II_126();

//        List<String> neighbours=s.getNeighbors("hit",wordList);
//        System.out.println(neighbours);
        List<List<String>>res=s.findLadders(beginWord,endWord,wordList);
        System.out.println(res);
    }
}
