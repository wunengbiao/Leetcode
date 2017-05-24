package Queue;

/**
 * Created by wunengbiao on 2017/4/1.
 */
public class Max_Sum_of_Rectangle_No_Larger_Than_K_363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length==0) return 0;
        compute_sum(matrix);

        int res=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                for(int x=i;x<matrix.length;x++){
                    for(int y=j;y<matrix[0].length;y++){
                        int area=matrix[x][y];
                        if(i-1>=0) area-=matrix[i-1][y];
                        if(j-1>=0) area-=matrix[x][j-1];
                        if(i-1>=0 && j-1>=0) area+=matrix[i-1][j-1];
                        if(area<=k){
                            res=Math.max(res,area);
                        }
                    }
                }
            }
        }

        return res;

    }

    public void compute_sum(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int up=i-1<0?0:matrix[i-1][j];
                int left=j-1<0?0:matrix[i][j-1];
                int diag=(i-1<0 || j-1<0)?0:matrix[i-1][j-1];
                matrix[i][j]=matrix[i][j]+up+left-diag;
            }
        }
    }

    public static void main(String[] args){
        Max_Sum_of_Rectangle_No_Larger_Than_K_363 s=new Max_Sum_of_Rectangle_No_Larger_Than_K_363();
        int[][] matrix={
                {1,0,1},
                {0,-2,3}
        };

        System.out.println(s.maxSumSubmatrix(matrix,2));
    }
}
