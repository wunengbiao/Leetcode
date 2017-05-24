package TopLogical;

/**
 * Created by wunengbiao on 2017/5/17.
 */
public class Longest_Increasing_Path_in_a_Matrix_329 {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int[][] cache=new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int lenght=dfs(i,j,matrix,cache,Integer.MAX_VALUE);
                max=Math.max(lenght,max);
            }
        }
        return max;
    }

    public int dfs(int reqx,int reqy,int[][] matrix,int[][] result,int pre){

        if(reqx>=matrix.length || reqx<0 || reqy>=matrix[0].length || reqy<matrix[0].length || matrix[reqx][reqy]>=pre) return 0;
        if(result[reqx][reqy]!=0){
            return result[reqx][reqy];
        }else{
            pre=matrix[reqx][reqy];

            int tempMax=0;
            tempMax=Math.max(dfs(reqx,reqy-1,matrix,result,pre),tempMax);
            tempMax=Math.max(dfs(reqx,reqy+1,matrix,result,pre),tempMax);
            tempMax=Math.max(dfs(reqx-1,reqy,matrix,result,pre),tempMax);
            tempMax=Math.max(dfs(reqx+1,reqy,matrix,result,pre),tempMax);

            result[reqx][reqy]=++tempMax;
            return tempMax;
        }
    }
    public static void main(String[] args){
        Longest_Increasing_Path_in_a_Matrix_329 s=new Longest_Increasing_Path_in_a_Matrix_329();
        int[][] matrix={{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        System.out.println(s.longestIncreasingPath(matrix));
    }
}
