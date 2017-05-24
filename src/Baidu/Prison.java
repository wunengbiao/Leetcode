package Baidu;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/11.
 */
public class Prison {

    public int solve(int[] array,int threshold,int c){
        if(array.length<c) return 0;
        int result=0;
        int sum=0;
        for(int i=0;i<c;i++){
            sum+=array[i];
        }

        result=sum<=threshold?1:0;

        for(int i=1;i<array.length;i++){

            if(i+c-1<=array.length-1){
                sum=sum-array[i-1]+array[i+c-1];
                if(sum<=threshold) result++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Prison prison=new Prison();
        Scanner in=new Scanner(System.in);

        int[] arr=null;
        while(in.hasNext()){
            int n=in.nextInt();
            int t=in.nextInt();
            int c=in.nextInt();
            arr=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
            }

            System.out.println(prison.solve(arr,t,c));
        }
    }
}
