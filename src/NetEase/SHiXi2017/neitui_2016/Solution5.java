package NetEase.SHiXi2017.neitui_2016;

import ChinaMobile.Solution;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/9.
 *
 * [编程题] 分苹果
    n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，
    使得最后所有奶牛拥有的苹果数都相同，每一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，
    问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 */
public class Solution5 {
    public int solve(int[] apples){
        int n=apples.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=apples[i];
        }
        if(sum%n!=0)return  -1;
        int means=sum/n;

        if(means%2==0){
            for(int i=0;i<n;i++){
                if(apples[i]%2!=0) return -1;
            }
        }

        if(means%2==1){
            for(int i=0;i<n;i++){
                if(apples[i]%2!=1) return -1;
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(apples[i]>means){
                count+=(apples[i]-means)/2;
            }
        }

        return count;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Solution5 s=new Solution5();
        int n=0;
        int[] apples=null;
        while(in.hasNext()){
            n=in.nextInt();
            apples=new int[n];

            for(int i=0;i<n;i++){
                apples[i]=in.nextInt();
            }
            System.out.println(s.solve(apples));
        }
    }
}
