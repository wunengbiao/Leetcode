package TYVJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/18.
 */
public class P1080 {
    List<int[]> res=new ArrayList<>();
    int count=0;
    public void solve(int t,int n,int[] path){
        if(t>n){
            if(res.size()<3){
                int[] tmp=Arrays.copyOf(path,n+1);
                res.add(tmp);
            }
            count++;
            return;
        }

        for(int i=1;i<=n;i++){
            path[t]=i;
            if(place(t,path)){
                solve(t+1,n,path);
            }
        }
    }

    public boolean place(int k,int[] path){
        for(int i=1;i<k;i++){
            if(Math.abs(k-i)==Math.abs(path[i]-path[k]) || path[i]==path[k]) return false;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        P1080 s=new P1080();

        int n=Integer.parseInt(in.nextLine());
        int[] path=new int[n+1];
        s.solve(1,n,path);
        for(int i=0;i<3;i++){
            int[] tmp=s.res.get(i);

            for(int j=1;j<n;j++){
                System.out.print(tmp[j]+" ");
            }
            System.out.println(tmp[n]);
        }
        System.out.println(s.count);
    }
}
