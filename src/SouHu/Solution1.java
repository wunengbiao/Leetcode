package SouHu;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2016/9/21.
 */
public class Solution1 {

    public int solve(int nums[],int m){
        int n=nums.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n;j++){
                int temp=nums[i]^nums[j];
                if(temp>m){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String[] strings=scanner.nextLine().split(" ");
        String[] nums=scanner.nextLine().split(" ");


        int count=Integer.parseInt(strings[0]);
        int border=Integer.parseInt(strings[1]);

        Solution1 solution1=new Solution1();

        int[] nums_int=new int[count];
        for(int i=0;i<count;i++){
            nums_int[i]=Integer.parseInt(nums[i]);
        }
        int ret=solution1.solve(nums_int,border);
        System.out.println(ret);
    }
}

