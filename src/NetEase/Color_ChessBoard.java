package NetEase;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/14.
 */
public class Color_ChessBoard {
    public int solve(int[][] chessboard){
        if(chessboard.length==0 || chessboard[0].length==0) return 0;
        int[] arr=new int[chessboard[0].length];
        for(int i=0;i<chessboard[0].length;i++){
            arr[i]=chessboard[0][i];
        }

        int res=kadane(arr);

        for(int i=1;i<chessboard.length;i++){
            for(int j=0;j<chessboard[0].length;j++){
                if(chessboard[i][j]==0) arr[j]=0;
                else arr[j]+=chessboard[i][j];
            }

            res=Math.max(res,kadane(arr));
        }
        return res;
    }

    public int kadane(int[] arr){
        int res=arr[0];
        int cur=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]) {
                res=Math.max(res,cur);
                cur=arr[i];
            }
            else{
                cur+=arr[i];
            }

        }
        return Math.max(res,cur);
    }

    public static void main(String[] args){
        Color_ChessBoard s=new Color_ChessBoard();
        Scanner in=new Scanner(System.in);

        int[][] m1;
        int[][] m2;
        while(in.hasNext()){
            int n=Integer.parseInt(in.nextLine());
            m1=new int[n][n];
            m2=new int[n][n];

            for(int i=0;i<n;i++){
                String line=in.nextLine();

                for(int j=0;j<line.length();j++){
                    if(line.charAt(j)=='W'){
                        m1[i][j]=1;
                    }else{
                        m2[i][j]=1;
                    }
                }
            }

            int res1=s.solve(m1);
            int res2=s.solve(m2);
            System.out.println(Math.max(res1,res2));
        }
    }
}
