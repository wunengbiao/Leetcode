package SouHu;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/9.
 */
public class DieluoHan {

    public int maxLength(int[] array){
        int[] dp=new int[array.length];
        Arrays.fill(dp,1);

        for(int i=1;i<array.length;i++){
            for(int j=0;j<i;j++){
                if(array[j]<=array[i] && dp[i]<dp[j]+1)
                    dp[i]=dp[j]+1;
            }
        }

        int max=0;
        for(int i=0;i<dp.length;i++){
            max=Math.max(dp[i],max);
        }

        return max;
    }

    public int solve(int[] weights,int[] heights){
        sort(weights,heights);
        System.out.println(Arrays.toString(heights));
        return maxLength(heights);
    }

    public void sort(int[] weigths,int[] heights){
        for(int i=0;i<weigths.length;i++){

            int min=i;
            for(int j=i+1;j<weigths.length;j++){
                if(weigths[j]<weigths[min])
                    min=j;
            }

            if(min!=i){
                int temp=weigths[min];
                weigths[min]=weigths[i];
                weigths[i]=temp;

                int temp2=heights[min];
                heights[min]=heights[i];
                heights[i]=temp2;
            }
        }

    }

    public static void main(String[] args){
        DieluoHan s=new DieluoHan();
        int[] weights={65,75,80,60,82,81};
        int[] heights={100,80,100,95,101,70};
        System.out.println(s.solve(weights,heights));
    }
}
