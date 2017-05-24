package TYVJ;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/18.
 */
public class P1016 {
    public int solve(int[] array,int n){
        if(array==null || array.length==0) return n;
        int[] dp=new int[n+1];
        for(int i=0;i<array.length;i++){
            for(int j=n;j>=array[i];j--){
                dp[j]=Math.max(dp[j],dp[j-array[i]]+array[i]);
            }
        }
        return n-dp[n];
    }

    public static void main(String[] args){
        P1016 s=new P1016();
        Scanner in=new Scanner(System.in);
        int v=Integer.parseInt(in.nextLine());
        int n=Integer.parseInt(in.nextLine());
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=Integer.parseInt(in.nextLine());
        }
        System.out.println(s.solve(array,v));
    }
}
