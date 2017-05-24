package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wunengbiao on 2017/4/3.
 */
public class The_Skyline_Problem_218 {
    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> res=new ArrayList<>();
        int max=0;
        for(int i=0;i<buildings.length;i++){
            if(buildings[i][1]>max) max=buildings[i][1];
        }

        int[] height=new int[max+2];
        height[max+1]=0;

        for(int i=0;i<buildings.length;i++){
            for(int j=buildings[i][0];j<=buildings[i][1];j++){
                height[j]=Math.max(height[j],buildings[i][2]);
            }
        }
        System.out.println(Arrays.toString(height));

        for(int i=0;i<=max+1;i++){
            int before=i==0?0:height[i-1];
            if(height[i]>before){
                res.add(new int[]{i,height[i]});
            }else if(height[i]<before){
                res.add(new int[]{i-1,height[i]});
            }
        }

        return res;
    }

    public static void main(String[] args){
        The_Skyline_Problem_218 s=new The_Skyline_Problem_218();
//        int[][] buildings={{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        int[][] buildings={{0,2147483647,2147483647}};
        System.out.println(s.getSkyline(buildings));
        for(int[] point:s.getSkyline(buildings)){
            System.out.println(point[0]+","+point[1]);
        }
        System.out.println();
    }
}
