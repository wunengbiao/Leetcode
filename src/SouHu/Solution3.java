package SouHu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2016/9/23.
 */
public class Solution3 {

    static int count=0;
    static int sum=0;

    public void solve(int nums[],int len,int m,int i) {

        if(i>len-1){
            if(sum==m){
                count++;
            }
            return;
        }
        if(sum+nums[i]<=m){
            sum+=nums[i];
            solve(nums,len,m,i+1);
            sum-=nums[i];
        }

        solve(nums,len,m,i+1);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String[] str=scanner.nextLine().split(" ");
        int len=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);

        String[] str_num=scanner.nextLine().split(" ");
        int[] nums=new int[len];
        for(int i=0;i<len;i++){
            nums[i]=Integer.parseInt(str_num[i]);
        }
        Arrays.sort(nums);

        Solution3 s=new Solution3();
        s.solve(nums,len,m,0);
        System.out.println(s.count);
    }
}
