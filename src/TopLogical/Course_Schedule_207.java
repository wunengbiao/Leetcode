package TopLogical;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/16.
 */
public class Course_Schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] course=new List[numCourses];
        int[] map=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            course[i]=new ArrayList<Integer>();
        for(int i=0;i<prerequisites.length;i++)
            course[prerequisites[i][0]].add(prerequisites[i][1]);
        for(int i=0;i<numCourses;i++)
            if(dfs(course,i,map)==false) return false;
        return true;

    }

    public boolean dfs(List[] courses,int req,int[] map){
        if(map[req]==0){
            map[req]=1;
            for(int i=0;i<courses[req].size();i++){
                if(dfs(courses,(int)courses[req].get(i),map)==false) return false;
            }
            map[req]=2;
        }
        else if(map[req]==1) return false;
        else if(map[req]==2) return true;
        return true;

    }
}
