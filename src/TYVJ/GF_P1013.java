package TYVJ;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/4/17.
 */
public class GF_P1013 {
    public int solve(int m,int r,int[][] mm){
        int max=0;
        int min=Integer.MAX_VALUE;
        int n=mm.length;
        int[][] f=new int[m+1][r+1];
        int[][] time=new int[m+1][r+1];

        for(int i=0;i<=m;i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<mm.length;i++){
            for(int j=m;j>=mm[i][0];j--){
                for(int k=r;k>=mm[i][1];k--){
                    if(f[j][k]<f[j-mm[i][0]][k-mm[i][1]]+1){
                        f[j][k]=f[j-mm[i][0]][k-mm[i][1]]+1;
                        if(time[j][k]==Integer.MAX_VALUE) time[j][k]=mm[i][2];
                        else time[j][k]=time[j-mm[i][0]][k-mm[i][1]]+mm[i][2];
                    }else if(f[j][k]==f[j-mm[i][0]][k-mm[i][1]]+1){
                        if(time[j-mm[i][0]][k-mm[i][1]]==Integer.MAX_VALUE)
                            time[j][k]=Math.min(time[j][k],mm[i][2]);
                        else
                            time[j][k]=Math.min(time[j][k],time[j-mm[i][0]][k-mm[i][1]]+mm[i][2]);
                    }

                    if(max<f[j][k]){
                        max=f[j][k];
                        min=time[j][k];
                    }else if(max==f[j][k]){
                        min=Math.min(min,time[j][k]);
                    }

                }
            }
        }

        return min;
    }

    public static void main(String[] args){
        GF_P1013 s=new GF_P1013();
        int m=5,r=5;
        int[][] mm={
                {1,2,5},
                {2,1,6},
                {2,2,2},
                {2,2,3}
        };

        System.out.println(s.solve(m,r,mm));
    }

    /**
     * Created by wunengbiao on 2017/4/16.
     */
    public static class Ski_1004 {

        public int dfs(int i,int j,int[][] matrix,int[][] cache,int pre){

            if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]>=pre){
                return 0;
            }
            if(cache[i][j]>0){
                return cache[i][j];
            }else{
                int cur=matrix[i][j];
                int tempMax=0;
                tempMax=Math.max(dfs(i-1,j,matrix,cache,cur),tempMax);
                tempMax=Math.max(dfs(i+1,j,matrix,cache,cur),tempMax);
                tempMax=Math.max(dfs(i,j-1,matrix,cache,cur),tempMax);
                tempMax=Math.max(dfs(i,j+1,matrix,cache,cur),tempMax);
                cache[i][j]=++tempMax;
                return tempMax;
            }
        }
    private int findSmallAround(int i,int j,int[][] matrix,int[][] cache,int pre){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]>=pre){
            return 0;
        }

        if(cache[i][j]>0){
            return cache[i][j];
        }else{
            int cur=matrix[i][j];
            int tempMax=0;

            tempMax=Math.max(findSmallAround(i-1,j,matrix,cache,cur),tempMax);
            tempMax=Math.max(findSmallAround(i+1,j,matrix,cache,cur),tempMax);
            tempMax=Math.max(findSmallAround(i,j-1,matrix,cache,cur),tempMax);
            tempMax=Math.max(findSmallAround(i,j+1,matrix,cache,cur),tempMax);

            cache[i][j]=++tempMax;
            return tempMax;
        }
    }

        public int solve(int[][] matrix){
            if(matrix.length==0 || matrix[0].length==0) return 0;
            int[][] status=new int[matrix.length][matrix[0].length];
            int max=0;

            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
    //                int length=findSmallAround(i,j,matrix,status,Integer.MAX_VALUE);
                    int length=dfs(i,j,matrix,status,Integer.MAX_VALUE);
                    max=Math.max(length,max);
                }
            }

            return max;
        }

        public static void main(String[] args){
            Ski_1004 s=new Ski_1004();
            int[][] matrix={{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
            System.out.println(s.solve(matrix));
        }
    }
}
