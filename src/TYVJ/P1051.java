package TYVJ;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/1.
 */
public class P1051 {

    int n;
    int tot;
    int[][] f;
    int[] ver;
    int[] next;
    int[] head;
    int[] c;

    public P1051(int n){
        this.n=n;
        tot=0;
        f=new int[500][500];
        ver=new int[500];
        next=new int[500];
        head=new int[500];
        c=new int[500];
    }

    public void add(int x,int y){
        tot++;
        ver[tot]=y;
        next[tot]=head[x];
        head[x]=tot;
    }

    public int sxdp(int x){
        int t=1;
        int now;
        f[x][1]=c[x];

        for(int k=head[x];k!=0;k=next[k]){
            int y=ver[k];
            now=sxdp(y);

            System.out.println("t:"+t);
            for(int i=t;i>=1;i--){

                System.out.println("now:"+now);
                for(int j=1;j<=now;j++){
                    System.out.println("i:"+i+"-j:"+j+"="+(i+j));
                    f[x][i+j]=Math.max(f[x][i+j],f[x][i]+f[y][j]);
                }
            }

            t+=now;
        }

        return t;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        String[] nums=in.nextLine().split(" ");
        int n=Integer.parseInt(nums[0]);
        int m=Integer.parseInt(nums[1]);

        P1051 s=new P1051(n);
        for(int i=1;i<=n;i++){
            String[] strs=in.nextLine().split(" ");
            s.c[i]=Integer.parseInt(strs[1]);
            s.add(Integer.parseInt(strs[0]),i);
        }

        s.sxdp(0);
        System.out.println(s.f[0][m+1]);
    }
}
