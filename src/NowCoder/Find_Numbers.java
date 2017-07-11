package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/5.
 */
public class Find_Numbers {
    public int solve(int a,int b,int c){
        if(a<0){
            a=a/c;
        }else{
            if(a%c!=0){
                a=a/c+1;
            }
        }

        if(b<0){
            if(b%c!=0){
                b=b/c-1;
            }
        }else{
            b=b/c;
        }

        return b-a+1;
    }

    public static void main(String[] args){
       Find_Numbers s=new Find_Numbers();
        Scanner in=new Scanner(System.in);

        String[] strs=in.nextLine().split(" ");
        int a=Integer.parseInt(strs[0]);
        int b=Integer.parseInt(strs[1]);
        int c=Integer.parseInt(strs[2]);

        System.out.println(s.solve(a,b,c));
    }
}
