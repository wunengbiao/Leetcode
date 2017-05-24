package QuanGuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/11.
 */
public class How_Many_FIshes {

    public int solve(int[] array,int minSize,int maxSize){
        int count=0;
        if(array.length==0) return maxSize-minSize+1;

        int n=array.length;
        Arrays.sort(array);

        int min=array[0];
        int max=array[n-1];

        for(int i=minSize;i<=maxSize;i++){
            if(i>=min && i<=max) count++;
            else if(i>max && i>10*min && i<2*min && i<2*max) count++;
            else if(i<min && 2*i<min) count++;
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
