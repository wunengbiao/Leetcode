package leet;

import ChinaMobile.Solution;

/**
 * Created by wunengbiao on 2016/9/26.
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

        int[][] cost=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            cost[i][0]=i;
        for(int i=0;i<=n;i++)
            cost[0][i]=i;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word1.charAt(i)==word2.charAt(j))
                    cost[i+1][j+1]=cost[i][j];
                else{
                    int a=cost[i][j];
                    int b=cost[i][j+1];
                    int c=cost[i+1][j];

                    cost[i+1][j+1]=a<b?(a<c?a:c):(b<c?b:c);
                    cost[i+1][j+1]++;
                }
            }
        }
        return cost[m][n];
    }

    public static void main(String[] args){
        Solution72 s=new Solution72();
        String word1="intention";
        String word2="execution";
        String w7="distance";
        String w8="springbok";
        int res=s.minDistance(w7,w8);
        System.out.println(res);
    }
}
