package NowCoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class Continous_Integer {

    public void solve(int[] nums){
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);

        boolean find=false;
        boolean flag=true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>2){
                flag=false;
                break;
            }
            else if(nums[i]==nums[i-1]+1) continue;
            else if(nums[i]==nums[i-1]+2){
                if(!find){
                    res.add(nums[i-1]+1);
                    find=true;
                }else {
                    flag=false;
                    break;
                }
            }
            else {
                flag=false;
            }
        }

        if(!flag){
            System.out.println("MISTAKE");
        }else{
            if(find){
                System.out.println(res.get(0));
            }else{
                int res1=nums[0]-1;
                if(res1>0) System.out.print(res1+" ");
                int res2=nums[nums.length-1]+1;
                System.out.println(res2);
            }
        }
    }

    public static void main(String[] args){
        Continous_Integer s=new Continous_Integer();
        Scanner in=new Scanner(System.in);

        int n=Integer.parseInt(in.nextLine());
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=in.nextInt();
        }
        s.solve(nums);
    }
}
