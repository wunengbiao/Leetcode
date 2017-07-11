package NowCoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/5.
 */
public class Make_Triangle {
    public int solve(int[] edges){
        if(edges.length<3) return 0;

        int count=0;
        Arrays.sort(edges);

        for(int i=0;i<edges.length-2;i++){
            for(int j=i+1;j<edges.length-1;j++){
                for(int z=j+1;z<edges.length;z++){
                    if(isValid(edges[i],edges[j],edges[z])){
                        count++;
                    }else {
                        break;
                    }
                }
            }
        }

        return count;
    }

    public boolean isValid(int a,int b,int c){
        if(a+b>c && a+c>b && b+a>a) return true;
        return false;
    }

    public static void main(String[] args){
        Make_Triangle s=new Make_Triangle();
        Scanner in=new Scanner(System.in);

        int n=Integer.parseInt(in.nextLine());
        int[] edges=new int[n];
        String[] strs=in.nextLine().split(" ");
        for(int i=0;i<n;i++){
            edges[i]=Integer.parseInt(strs[i]);
        }
        System.out.println(s.solve(edges));
    }
}
