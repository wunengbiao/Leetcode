package MeiTuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2016/10/11.
 */
public class M2 {


    void pathGenerate(int n,int m,int[] path,int end){
        if(n==end && m==end){
            for(Integer step:path){
                System.out.print(step);
                System.out.print(' ');
            }
            System.out.println();
            return;
        }

        if(m<n){
            path[n+m]=0;
            pathGenerate(n,m+1,path,end);

        }
        if(n<end){
            path[n+m]=1;
            pathGenerate(n+1,m,path,end);
        }


    }

    int solution(int n){

        if(n==0) return 0;
        if(n==1) return 1;

        int[][] dp=new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            for(int j=0;j<=i;j++){
                if(j-1>=0 && j<=i-1){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+1;
                }
                if(j-1>=0 && j>i-1){
                    dp[i][j]=dp[i][j-1];
                }
                if(j-1<0 && j<=i-1){
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][n];


    }

    public static void main(String[] args){
        M2 s=new M2();
        int ret=s.solution(4);
        System.out.println(ret);
        int[] path=new int[6];
        s.pathGenerate(0,0,path,3);
    }
}
