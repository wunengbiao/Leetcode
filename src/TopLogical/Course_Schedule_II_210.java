package TopLogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/4/8.
 */
public class Course_Schedule_II_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] course=new List[numCourses];
        int[] map=new int[numCourses];
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<numCourses;i++)
            course[i]=new ArrayList<Integer>();
        for(int i=0;i<prerequisites.length;i++)
            course[prerequisites[i][0]].add(prerequisites[i][1]);
        for(int i=0;i<numCourses;i++)
            if(dfs(course,i,ans,map)==false) return new int[0];
        int[] an=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            an[i]=ans.get(i);
        return an;
    }
    public boolean dfs(List[] course,int req,List<Integer> ans,int[] map)
    {
        if(map[req]==0)
        {
            map[req]=1;
            for(int i=0;i<course[req].size();i++)
                if(dfs(course,(int)course[req].get(i),ans,map)==false) return false;
            map[req]=2;
        }
        else if(map[req]==1) return false;
        else if(map[req]==2) return true;
        ans.add(req);
        return true;
    }

    public static void main(String[] args){
        Course_Schedule_II_210 s=new Course_Schedule_II_210();
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(s.findOrder(4,prerequisites)));


    }
}
