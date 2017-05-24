package Baidu;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/11.
 */
public class Fish {
    public double solve(double[][] arr,int x,int y,int t){
        int n=arr.length;
        int m=arr[0].length;
        float sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=arr[i][j];
            }
        }

        double cc=arr[x-1][y-1];
        double ss=sum/(n*m);

        if(cc==ss){
            System.out.println("equal");
            return 1-Math.pow(1-cc,t);
        }
        if(cc>ss){
            System.out.println("cc");
            return 1-Math.pow(1-cc,t);
        }
        else{
            System.out.println("ss");
            return 1-Math.pow(1-ss,t);
        }
    }

    public static void main(String[] args){
        Fish fish=new Fish();

        Scanner in=new Scanner(System.in);
        double[][] arr=null;

        while(in.hasNext()){
            int n=in.nextInt();
            int m=in.nextInt();
            int x=in.nextInt();
            int y=in.nextInt();
            int t=in.nextInt();

            arr=new double[n][m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=in.nextDouble();
                }
            }
            double res=fish.solve(arr,x,y,t);
            System.out.println(res);

        }
    }
}
