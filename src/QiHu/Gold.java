package QiHu;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/20.
 */
public class Gold {

    public int solve(int i,int j,int[] sum){
        if(i==j) return sum[j]-sum[i-1];
        else return sum[j]-sum[i-1]-Math.min(solve(i+1,j,sum),solve(i,j-1,sum));
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int size=Integer.parseInt(in.nextLine());

        int[] sum=new int[size+1];
        String[] nums=in.nextLine().split(" ");
        for(int i=0;i<size;i++){
            sum[i+1]=Integer.parseInt(nums[i])+sum[i];
        }

        Gold gold=new Gold();
        System.out.println(gold.solve(1,size,sum));
    }
}
