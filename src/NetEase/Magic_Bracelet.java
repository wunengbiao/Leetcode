package NetEase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/13.
 */
public class Magic_Bracelet {
//    public void solve(int[][] arr,int k){
//        int n=arr[0].length;
//        int[][] transfrom=new int[arr[0].length][arr[0].length];
//        for(int i=0;i<n;i++){
//            if(i<n-1){
//                transfrom[i][i]=1;
//                transfrom[i][i+1]=1;
//            }else{
//                transfrom[i][i]=1;
//                transfrom[i][0]=1;
//            }
//        }
//
//        for(int i=0;i<k;i++){
//            int[][] res=multiply(transfrom,arr);
//            System.out.println(Arrays.toString(res));
//            arr=res;
//        }
//    }
//
//    public void multiply(int[][] A,int [][] B,int[][] C){
//        int m=A.length;
//        int n=B[0].length;
//        int[][] res=new int[m][n];
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                for(int z=0;z<A[0].length;z++){
//                    res[i][j]+=A[i][z]*B[z][i];
//                }
//                res[i][j]%=100;
//            }
//        }
//
//    }

    public static void main(String[] args){
        Magic_Bracelet s=new Magic_Bracelet();
        Scanner in=new Scanner(System.in);

        int[][] arr;
        while(in.hasNext()){
            String[] line=in.nextLine().split(" ");
            int n=Integer.parseInt(line[0]);
            int k=Integer.parseInt(line[1]);

            arr=new int[1][n];
            for(int i=0;i<n;i++){
                arr[0][i]=in.nextInt();
            }
//            s.solve(arr,k);

            for(int i=0;i<n-1;i++){
                System.out.print(arr[0][i]+" ");
            }
            System.out.println(arr[0][n-1]);
        }
    }
}
