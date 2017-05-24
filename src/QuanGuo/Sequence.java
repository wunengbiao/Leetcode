package QuanGuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/12.
 */
public class Sequence {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());

        int[] arr=new int[n];
        String str=in.nextLine();
        String[] strs=str.split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(strs[i]);
        }

        Arrays.sort(arr);

        boolean valid=true;
        boolean found=false;
        int res=0;

        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]==1) continue;
            else if(arr[i]-arr[i-1]==2 && !found){
                found=true;
                res=arr[i]-1;
            }else{
                valid=false;
                System.out.println("mistake");
                break;
            }
        }

        if(found && valid)
            System.out.println(res);
        else if(!found && valid){
//            System.out.println((arr[0]-1)+" "+(arr[n-1]+1));
            if(arr[0]-1>0) System.out.print((arr[0]-1)+" ");
            System.out.println(arr[n-1]+1);
        }
    }
}
