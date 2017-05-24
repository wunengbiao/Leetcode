package Divid_and_Conquer;

import java.util.*;

/**
 * Created by wunengbiao on 2017/3/27.
 */
public class The_Skyline_Problem_218 {
//    public List<int[]> getSkyline(int[][] buildings) {
//
//        List<int[]> res=new ArrayList<>();
//        List<int[]> points=new ArrayList<>();
//
//        for(int i=0;i<buildings.length;i++){
//            int[] a=buildings[1];
//            points.add(new int[]{a[1],a[2]});
//        }
//
//        Collections.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0]!=o2[0])
//                    return o1[0]-o2[1];
//                else return o1[1]-o2[1];
//            }
//        });
//
//        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(buildings.length, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//
//        int cur=0,pre=0;
//
//        for(int i=0;i<points.size();i++){
//            int[] b=points.get(i);
//            if(b[1]>0){
//                maxHeap.add(b[1]);
//                cur=maxHeap.peek();
//            }else{
//                maxHeap.remove()
//            }
//        }
//    }


}
