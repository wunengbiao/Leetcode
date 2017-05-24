package Greedy;

import leet.Solution135;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/12.
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        int[] count=new int[ratings.length];
        Arrays.fill(count,1);

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                count[i]=count[i-1]+1;
        }

        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && count[i]<count[i+1]+1) count[i]=count[i+1]+1;
        }

        int sum=0;
        for(int i=0;i<count.length;i++){
            sum+=count[i];
        }

        return sum;
    }

    public static void main(String[] args){
        int a[]={2,1};
        Candy_135 s=new Candy_135();
        System.out.println(s.candy(a));
    }
}
