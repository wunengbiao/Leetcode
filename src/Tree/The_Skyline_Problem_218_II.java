package Tree;

import java.util.*;

/**
 * Created by wunengbiao on 2017/4/8.
 */

public class The_Skyline_Problem_218_II {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result=new ArrayList<>();
        List<int[]> height=new ArrayList<>();

        for(int[] b:buildings){
            height.add(new int[]{b[0],-b[2]});
            height.add(new int[]{b[1],b[2]});
        }

        Collections.sort(height,(a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1]-b[1];
        });

        Queue<Integer> pq=new PriorityQueue<>((a,b)->(b-a));
        pq.offer(0);

        int prev=0;

        for(int[] h:height){
            System.out.println("heap:"+pq);
            if(h[1]<0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }

            int cur=pq.peek();
            if(prev!=cur){
                result.add(new int[]{h[0],cur});
                prev=cur;
            }
        }

        return result;
    }

    public static void main(String[] args){
        The_Skyline_Problem_218_II s=new The_Skyline_Problem_218_II();
        int[][] buildings={{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
//        int[][] buildings={{0,2147483647,2147483647}};
//        System.out.println(s.getSkyline(buildings));
        for(int[] point:s.getSkyline(buildings)){
//            System.out.println(point[0]+","+point[1]);
        }
    }
}
