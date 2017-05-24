package DP;

/**
 * Created by wunengbiao on 2017/5/19.
 */
public class Out_of_Boundary_Paths_576 {
    private final int[] offsetX={-1,1,0,0};
    private final int[] offsetY={0,0,-1,1};

    public int findPaths(int m, int n, int N, int i, int j) {

        if(N==0) return 0;
        final int MOD=1000000007;
        int[][] count=new int[m][n];
        count[i][j]=1;
        int result=0;


        for(int step=0;step<N;step++){
            int[][] temp=new int[m][n];

            for(int r=0;r<m;r++){
                for(int c=0;c<n;c++){
                    for(int x=0;x<4;x++){
                        int nr=r+offsetX[x];
                        int nc=c+offsetY[x];

                        if(nr<0 || nr>=m || nc<0 || nc>=n){
                            result=(result+count[r][c])%MOD;
                        }else{
                            temp[nr][nc]=(temp[nr][nc]+count[r][c])%MOD;
                        }
                    }
                }
            }
            count=temp;
        }

        return result;
    }

    public static void main(String[] args){
        Out_of_Boundary_Paths_576 s=new Out_of_Boundary_Paths_576();
        System.out.println(s.findPaths(2,2,2,0,0));
    }
}
