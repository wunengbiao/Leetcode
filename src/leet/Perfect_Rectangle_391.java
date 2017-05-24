package leet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/4/2.
 */
public class Perfect_Rectangle_391 {
    public boolean isRectangleCover(int[][] rectangles) {

        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        int up=Integer.MIN_VALUE;
        int down=Integer.MAX_VALUE;
        Set<String> set=new HashSet<>();
        int totalArea=0;
        for(int i=0;i<rectangles.length;i++){
            left=Math.min(rectangles[i][0],left);
            down=Math.min(rectangles[i][1],down);
            right=Math.max(rectangles[i][2],right);
            up=Math.max(rectangles[i][3],up);

            totalArea+=(rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
            String pointLT=rectangles[i][0]+" "+rectangles[i][3];
            String pointLB=rectangles[i][0]+" "+rectangles[i][1];
            String pointRT=rectangles[i][2]+" "+rectangles[i][3];
            String pointRB=rectangles[i][2]+" "+rectangles[i][1];

            if(!set.contains(pointLT)) set.add(pointLT); else set.remove(pointLT);
            if(!set.contains(pointLB)) set.add(pointLB); else set.remove(pointLB);
            if(!set.contains(pointRT)) set.add(pointRT); else set.remove(pointRT);
            if(!set.contains(pointRB)) set.add(pointRB);else set.remove(pointRB);
        }
        if(set.size()==4 && set.contains(left+" "+up) && set.contains(left+" "+down) && set.contains(right+" "+down) && set.contains(right+" "+up)){
            return totalArea==(right-left)*(up-down);
        }

        return false;

    }
}
