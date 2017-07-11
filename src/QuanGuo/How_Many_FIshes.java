package QuanGuo;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/11.
 */
public class How_Many_FIshes {

    public int solve(int[] array,int minSize,int maxSize){
        int count=0;
        int n=array.length;

        for(int i=minSize;i<=maxSize;i++){
            int flag=1;
           for(int j=0;j<n;j++){
               if(i>=array[j]*2 && i<=array[j]*10 || i*2<=array[j] && i*10>=array[j]){
                   flag=0;
               }
           }

           if(flag==1) count++;
        }

        return count;
    }

    public static void main(String[] args){
        How_Many_FIshes s=new How_Many_FIshes();
        Scanner in=new Scanner(System.in);

        int minSize=in.nextInt();
        int maxSzie=in.nextInt();

        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }

        System.out.println(s.solve(arr,minSize,maxSzie));
    }
}
