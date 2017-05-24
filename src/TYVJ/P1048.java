package TYVJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/23.
 */
public class P1048 {
    public int solve(int[] T,int[] Q){
        int n=T.length;


        Arrays.sort(T);
        Arrays.sort(Q);

        int i1=0,i2=n-1;
        int j1=0,j2=n-1;

        int sum=0;
        while(i1<=i2){
            if(T[i1]>Q[j1]){
                i1++;
                j1++;
                sum++;
                continue;
            }

            if(T[i1]<Q[j1]){
                i1++;
                j2--;
                sum--;
                continue;
            }

            if(T[i1]==Q[j1]){
                if(T[i2]>Q[j2]){
                    i2--;
                    j2--;
                    sum++;
                    continue;
                }
                else{
                    if((T[i2]<Q[j2]))
                        sum--;
                    i1++;
                    j2--;
                    continue;
                }
            }

        }

        return sum*200;
    }

    public static void main(String[] args){
        P1048 s=new P1048();
        Scanner in=new Scanner(System.in);

        int n=Integer.parseInt(in.nextLine());

        int[] T=new int[n];
        int[] Q=new int[n];

        String[] tStr=in.nextLine().split(" ");
        String[] qStr=in.nextLine().split(" ");

        for(int i=0;i<n;i++){
            T[i]=Integer.parseInt(tStr[i]);
            Q[i]=Integer.parseInt(qStr[i]);
        }

        System.out.println(s.solve(T,Q));

    }
}
