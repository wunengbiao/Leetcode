package SouHu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2016/9/21.
 */
public class Solution2 {

    public int solve(int nums[]){
        int n=nums.length;
        int i=0;
        int count=0;
        while(i<n-2){
            if(isOK(nums[i],nums[i+1],nums[i+2])){
                i=i+3;
            }else {
                if(isOK(nums[i],nums[i+1])){
                    count++;
                    i=i+2;
                }else{
                    count+=2;
                    i=i+1;
                }


            }
        }

        if(i==n-1) count+=2;
        if(i==n-2){
            if(isOK(nums[n-2],nums[n-1])){
                count+=1;
            }else{
                count+=4;
            }
        }
        return count;
    }

    public boolean isOK(int a,int b,int c){
        if(b-a<=10 && c-b<=10){
            return true;
        }
        return false;
    }

    public boolean isOK(int a,int b){
        if(b-a<=20)
            return true;
        return false;
    }

    public static void main(String[] args){
        Solution2 s=new Solution2();
        Scanner scanner=new Scanner(System.in);

        int count=Integer.parseInt(scanner.nextLine());
        String[] nums_str=scanner.nextLine().split(" ");
        int[] nums=new int[count];
        for(int i=0;i<count;i++){
            nums[i]=Integer.parseInt(nums_str[i]);

        }
        Arrays.sort(nums);
        int ret=s.solve(nums);
        System.out.println(ret);

    }
}
