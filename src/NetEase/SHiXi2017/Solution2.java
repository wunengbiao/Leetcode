package NetEase.SHiXi2017;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/7.
 */
public class Solution2 {
    public int solve(int[][] matrix,int n){
        int N=matrix.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int down=0;
                if(i+n<=N)
                    for(int x=0;x<n;x++){
                        down+=matrix[i+x][j];
                    }
                max=Math.max(max,down);
                int right=0;
                if(j+n<=N)
                    for(int x=0;x<n;x++){
                        right+=matrix[i][j+x];
                    }
                max=Math.max(max,right);
                int left_to_right=0;
                if(i+n<=N && j+n<=N){
                    for(int x=0;x<n;x++){
                        left_to_right+=matrix[i+x][j+x];
                    }
                }
                max=Math.max(max,left_to_right);
                int down_to_up=0;
                if(i-n+1>=0 && j+n<=N){
                    for(int x=0;x<n;x++){
                        down_to_up+=matrix[i-x][j+x];
                    }
                }
                max=Math.max(max,down_to_up);
            }
        }

        return max;
    }

    public static void main(String[] args){
        Solution2 s=new Solution2();
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int D=scanner.nextInt();

        int[][] matrix=new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }

        System.out.println(s.solve(matrix,D));
    }
}
