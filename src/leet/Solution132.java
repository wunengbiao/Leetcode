package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2016/9/26.
 */
public class Solution132 {

    public static int minCut(String s) {
        int n=s.length();
        int[] f=new int[n+1];
        boolean[][] p=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                p[i][j]=false;
        }
        for(int i=0;i<=n;i++) f[i]=n-1-i;
        System.out.println(Arrays.toString(f));
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])){
                    p[i][j]=true;
                    f[i]=Math.min(f[i],f[j+1]+1);
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return f[0];
    }

    public static void main(String[] args){
        int ret=minCut("bb");
        System.out.println(ret);
    }

}

