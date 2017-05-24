package leet;

/**
 * Created by wunengbiao on 2017/4/8.
 */
public class Longest_Increasing_Path_in_a_Matrix_329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int[][] cache=new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int lenght=findSmallAround(i,j,matrix,cache,Integer.MAX_VALUE);
                max=Math.max(lenght,max);
            }
        }
        return max;
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

    public static void main(String[] args){
        Longest_Increasing_Path_in_a_Matrix_329 s=new Longest_Increasing_Path_in_a_Matrix_329();
        int[][] matrix={{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        System.out.println(s.longestIncreasingPath(matrix));
    }
}
