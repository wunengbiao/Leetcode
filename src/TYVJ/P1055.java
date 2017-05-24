package TYVJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/28.
 */
public class P1055 {
    public int solve(int[] array){

        int n=array.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for(int x=0;x<n;x++){
            for(int i=0;i<n-x;i++){
                int j=i+x;
                if(i==j){
                    dp[i][j]=array[i];
                    continue;
                }
                for(int k=i;k<j;k++){


                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        int[] array=new int[n];
        String[] strs=in.nextLine().split(" ");
        for(int i=0;i<n;i++){
            array[i]=Integer.parseInt(strs[i]);
        }
        P1055 s=new P1055();
        System.out.println(s.solve(array));
    }
}
