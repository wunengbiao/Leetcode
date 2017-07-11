package leet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by wunengbiao on 2017/7/3.
 */
public class Smallest_Range_632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> min=new PriorityQueue<>(1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //o1[0] 表示第K个List
                //o1[1]表示第个List的位置
                return nums.get(o1[0]).get(o1[1])-nums.get(o2[0]).get(o2[1]);
            }
        });

        PriorityQueue<int[]> max=new PriorityQueue<>(1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //o1[0] 表示第K个List
                //o1[1]表示第个List的位置
                return nums.get(o2[0]).get(o2[1])-nums.get(o1[0]).get(o1[1]);
            }
        });

        for(int i=0;i<nums.size();i++){
            int[] tmp=new int[]{i,0};
            min.offer(tmp);
            max.offer(tmp);
        }

        int[] res=new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE};

        while(min.size()==nums.size()){
            int[] m1=max.peek();
            int[] m2=min.poll();

            if((long)nums.get(m1[0]).get(m1[1])-(long)nums.get(m2[0]).get(m2[1])<(long)res[1]-(long)res[0]){
                res[0]=nums.get(m2[0]).get(m2[1]);
                res[1]=nums.get(m1[0]).get(m1[1]);
            }

            if(m2[1]+1<nums.get(m2[0]).size()){
                int[] m3=new int[]{m2[0],m2[1]+1};
                min.offer(m3);
                max.offer(m3);
                max.remove(m2);
            }
        }

        return res;

    }

//    public int[] smallestRange(List<List<Integer>> nums) {
//        int size=nums.size();
//        int[] p=new int[nums.size()];
//        int[] indexs=find(nums,p);
//
//        int[] res=new int[2];
//        res[0]=nums.get(indexs[0]).get(p[indexs[0]]);
//        res[1]=nums.get(indexs[1]).get(p[indexs[1]]);
//        p[indexs[0]]++;
//        while(p[indexs[0]]<nums.get(indexs[0]).size()){
//            indexs=find(nums,p);
//            if(nums.get(indexs[1]).get(p[indexs[1]])-nums.get(indexs[0]).get(p[indexs[0]])<res[1]-res[0]){
//                res[0]=nums.get(indexs[0]).get(p[indexs[0]]);
//                res[1]=nums.get(indexs[1]).get(p[indexs[1]]);
//            }
//            p[indexs[0]]++;
//        }
//        return res;
//
//    }
//
//    public int[] find(List<List<Integer>> nums,int[] p){
//        int max=0;
//        int min=0;
//        for(int i=1;i<nums.size();i++){
//            if(nums.get(i).get(p[i])>nums.get(max).get(p[max]))
//            max=i;
//            if(nums.get(i).get(p[i])<nums.get(min).get(p[min]))
//            min=i;
//        }
//        return new int[]{min,max};
//    }
    public static void main(String[] args){
        //[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
//        List<Integer> l1= Arrays.asList(1,2,3);
//        List<Integer> l2= Arrays.asList(1,2,3);
//        List<Integer> l3= Arrays.asList(1,2,3);
//        List<Integer> l1= Arrays.asList(4,10,15,24,26);
//        List<Integer> l2= Arrays.asList(0,9,12,20);
//        List<Integer> l3= Arrays.asList(5,18,22,30);

//        List<List<Integer>> nums=Arrays.asList(l1,l2,l3);
//        Smallest_Range_632 s=new Smallest_Range_632();
//        System.out.println(Arrays.toString(s.smallestRange(nums)));

        PriorityQueue<Integer> heap=new PriorityQueue<>(1);
        heap.offer(1);
        heap.offer(0);
        heap.offer(-1);
        System.out.println(heap.size());
    }
}
