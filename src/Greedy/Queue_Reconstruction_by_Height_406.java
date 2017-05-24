package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wunengbiao on 2017/4/9.
 */
public class Queue_Reconstruction_by_Height_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });

        List<int[]> res=new ArrayList<>();
        for(int i=0;i<people.length;i++){
            res.add(people[i][1],people[i]);
        }

        int[][] result=new int[people.length][2];
        for(int i=0;i<people.length;i++){
            result[i][0]=res.get(i)[0];
            result[i][1]=res.get(i)[1];
        }

        return result;
    }

    public static void main(String[] args){
        Queue_Reconstruction_by_Height_406 s=new Queue_Reconstruction_by_Height_406();

        int[][] people={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        int[][] res=s.reconstructQueue(people);
        for(int i=0;i<people.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
