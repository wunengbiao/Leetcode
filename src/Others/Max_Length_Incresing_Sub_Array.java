package Others;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/9.
 */
public class Max_Length_Incresing_Sub_Array {
    public int maxLength(int[] array){
        int[] dp=new int[array.length];
        Arrays.fill(dp,1);
        int[] path=new int[array.length];
        Arrays.fill(path,-1);

        for(int i=1;i<array.length;i++){
            for(int j=0;j<i;j++){
                if(array[j]<array[i] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    path[i]=j;
                }
            }
        }

        int max=0;
        int max_index=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max) max_index=i;
            max=Math.max(dp[i],max);
        }

        System.out.println(Arrays.toString(path));
        for(int i=max_index;i!=-1;i=path[i]){
            System.out.print(array[i]+" ");
        }
        System.out.println();


        return max;
    }

    public static void main(String[] args){
        Max_Length_Incresing_Sub_Array s=new Max_Length_Incresing_Sub_Array();
        int[] array={10,22,9,33,21,50,41,60,80};
        System.out.println(s.maxLength(array));
    }
}
