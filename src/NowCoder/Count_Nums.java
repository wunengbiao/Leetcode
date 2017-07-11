package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class Count_Nums {
    public void solve(int n){
        int[] res=new int[10];
        int j;
        for(int i=1;i<=n;i++){
            if(i>=10){
                j=i;
                while(j>0){
                    int m=j%10;
                    res[m]++;
                    j=j/10;
                }
            }else{
                res[i]++;
            }
        }

        for(int i=0;i<9;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println(res[9]);
    }

    public static void main(String[] args){
        Count_Nums s=new Count_Nums();
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        s.solve(n);
    }
}
