package TYVJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/2.
 */
public class P1019 {

    public int solve(int[] A,int[] B){
        int n=A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt=0;
        for(int i=0,j=n-1;i<n;i++,j--){
            cnt+=Math.abs(A[i]-B[j]);
        }

        return cnt;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        P1019 s=new P1019();

        int n=Integer.parseInt(in.nextLine());
        int[] A=new int[n];
        int[] B=new int[n];

        String[] strA=in.nextLine().split(" ");
        String[] strB=in.nextLine().split(" ");

        for(int i=0;i<n;i++){
            A[i]=Integer.parseInt(strA[i]);
            B[i]=Integer.parseInt(strB[i]);
        }

        System.out.println(s.solve(A,B));
    }
}
