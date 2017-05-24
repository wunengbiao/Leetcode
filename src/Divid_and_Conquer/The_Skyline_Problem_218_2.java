package Divid_and_Conquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/3/28.
 */
public class The_Skyline_Problem_218_2 {
    public List<int[]> getSkyline(int[][] buildings){
        int max=0;
        for(int i=0;i<buildings.length;i++){
            if(max>buildings[i][1])
                max=buildings[i][1];
        }

        int[] height=new int[max+1];

        for(int i=0;i<buildings.length;i++){
            for(int j=buildings[i][0];j<=buildings[i][1];i++){
                height[j]=Math.max(height[j],buildings[i][2]);
            }
        }

//        int cur=height[0];

        return new ArrayList<int[]>();
    }
}
