package TYVJ;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/17.
 */
public class P1012 {
    int[] cnt={6,2,5,5,4,5,6,3,7,6};
    public int get(int x){
        if(x==0) return 6;
        int total=0;
        while(x>0){
            total+=cnt[x%10];
            x/=10;
        }
        return total;
    }

    public int solve(int n){
        int count=0;
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                if(get(i)+get(j)+get(i+j)==n){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        P1012 s=new P1012();
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        if(n-4<=0)
            System.out.println(0);
        System.out.println(s.solve(n-4));
    }
}
