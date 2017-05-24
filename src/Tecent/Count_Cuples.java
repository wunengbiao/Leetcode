package Tecent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/16.
 */
public class Count_Cuples {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int count=Integer.parseInt(in.nextLine());

        if(count<=2)
            System.out.println(1+" "+1);
        String[] strs=in.nextLine().split(" ");
        int[] nums=new int[count];
        for(int i=0;i<count;i++){
            nums[i]=Integer.parseInt(strs[i]);
        }

        Arrays.sort(nums);
        System.out.println("SUCESS1");

        int min=nums[2]-nums[1];
        int counter=1;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==min) counter+=1;
            if(nums[i]-nums[i-1]<min){
                counter=1;
                min=nums[i]-nums[i-1];
            }
        }

        System.out.println("SUCCESS");

        int before=1;
        int after=0;
        int couter2=0;
        int i=1;
        while(i<count){
            if(nums[i]==nums[i-1]) before++;
            i++;
        }

        int j=count-1;
        while(j>0){
            if(nums[j]==nums[j-1]) after++;
            j--;
        }

        if(before==count)
            couter2=count*(count-1)/2;
        else
            couter2=before*after;
        System.out.println(counter+" "+couter2);
    }

}
