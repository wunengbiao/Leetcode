package leet;

import java.util.List;

/**
 * Created by wunengbiao on 2017/4/9.
 */
public class Course_Schedule_II_210_2 {
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//    }

    public boolean dfs(List[] course,int req,List<Integer> ans,int[] map){
        if(map[req]==0){
            map[req]=1;
            for(int i=0;i<course[req].size();i++){
                if(dfs(course,(int)course[req].get(i),ans,map)==false) return false;
                map[req]=2;
            }
        }else if(map[req]==1) return false;
        else if(map[req]==2) return true;

        ans.add(req);
        return true;
    }
}