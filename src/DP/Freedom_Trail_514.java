package DP;

import Greedy.Patching_Array_330;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/19.
 */
public class Freedom_Trail_514 {
//    public int findRotateSteps(String ring, String key) {
//        List[] map=new List[26];
//        for(int i=0;i<26;i++) map[i]=new ArrayList<Integer>();
//        for(int i=0;i<ring.length();i++){
//            map[ring.charAt(i)-'a'].add(i);
//        }
//
//        dfs(map,0,key,0,0,ring.length());
//        return res+key.length();
//    }
//
//    int res=Integer.MAX_VALUE;
//    public  int dfs(List<Integer>[] map,int start,String key,int i,int cur,int len,int[][] mem){
//        if(i==key.length()) {
//            res=Math.min(res,cur);
//            mem[start][key]
//        }
//
//        for(int next:map[key.charAt(i)-'a']){
//            int temp=Math.max(start,next)-Math.min(start,next);
//            int step=Math.min(temp,len-temp);
//            dfs(map,next,key,i+1,cur+step,len);
//        }
//    }
//
//    public static void main(String[] args){
//        Freedom_Trail_514 s=new Freedom_Trail_514();
//        System.out.println(s.findRotateSteps("caotmcaataijjxi","oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
//    }
}
