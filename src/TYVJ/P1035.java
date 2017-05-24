package TYVJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/19.
 */
public class P1035 {

    public int n;
    public boolean[][] cut;
    public int[] match;
    public boolean[] pd;

    private final int[] dx={1,-1,0,0};
    private final int[] dy={0,0,1,-1};

    public P1035(int n){
        this.n=n;
        cut=new boolean[n][n];
        match=new int[n*n]; //
        pd=new boolean[n*n];//存放增广路

    }
    boolean find(int p){
        int x=p/n,y=p%n;

        for(int i=0;i<4;i++){
            int x1=x+dx[i],y1=y+dy[i];
            int v=x1*n+y1;
            if(x1<0 || x1>=n || y1<0 || y1>=n) continue;
            if(pd[v] || cut[x1][y1]) continue;

            pd[v]=true;
            if(match[v]==-1 || find(match[v])){
                match[v]=p;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);

        String[] line1=in.nextLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int m=Integer.parseInt(line1[1]);

        P1035 s=new P1035(n);
        Arrays.fill(s.match,-1);

        for(int i=0;i<m;i++){
            String[] line=in.nextLine().split(" ");
            s.cut[Integer.parseInt(line[0])-1][Integer.parseInt(line[1])-1]=true;
        }

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                if(!s.cut[i][j] && ((i+j) & 1)==1){
                    Arrays.fill(s.pd,false);
                    if(s.find(i*n+j)) ans++;
                }
        }
        System.out.println(ans);

    }


}
