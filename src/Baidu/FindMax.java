package Baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by wunengbiao on 2016/9/24.
 */
public class FindMax {

    public static int solve(int m,int e){

        List<Integer> numsList=new ArrayList<>();

        while(m!=0){
            numsList.add(m%10);
            m/=10;
        }
        int n=numsList.size();
        if(m>n) return 0;


        Collections.reverse(numsList);
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=numsList.get(i);
        }

        int first=0;
        int count=0;
        int[] ret=new int[n-e];
        while(count<n-e){
            int max=-1;
            int index=first;
            for(int i=first;i<=e+count;i++){
                if(nums[i]>max){
                    max=nums[i];
                    index=i;
                }
            }
            ret[count]=max;
            first=index+1;
            count++;
        }

        int sum=0;
        for(int i=0;i<n-e;i++){
            sum=sum*10+ret[i];
        }
        return sum;
    }

    public static void main(String[] args){
        int ret=solve(325,1);
        System.out.println(ret);
    }
}
