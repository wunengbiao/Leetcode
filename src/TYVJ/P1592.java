package TYVJ;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/28.
 */
public class P1592 {

    public int kadane(int[] array){

        int cur=0;
        int sum=0;

        for(int i=0;i<array.length;i++){
            cur+=array[i];
            if(cur<0){
                cur=0;
            }else{
                sum=Math.max(sum,cur);
            }
        }

        return sum;
    }

    public int solve(int[][] arrays){

        int sum=0;
        for(int i=0;i<arrays.length;i++){

            int[] array=new int[arrays[0].length];
            for(int j=i;j<arrays.length;j++){
                for(int x=0;x<arrays[0].length;x++){
                    array[x]+=arrays[j][x];

                }
                sum=Math.max(sum,kadane(array));
            }
        }

        return sum-10>0?sum-10:0;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        P1592 s=new P1592();

        int n=Integer.parseInt(in.nextLine());

        int[][] arrays=new int[n][n];

        for(int i=0;i<n;i++){
            String[] strs=in.nextLine().split(" ");

            for(int j=0;j<n;j++){
                int num=Integer.parseInt(strs[j]);
                if(num==0) num=-1000000;
                arrays[i][j]=num;
            }
        }

        System.out.println(s.solve(arrays));
    }
}
