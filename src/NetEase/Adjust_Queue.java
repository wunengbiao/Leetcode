package NetEase;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/13.
 */
public class Adjust_Queue {
    public int solve(String s){
        int G=0;
        int B=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='G') G++;
            else B++;
        }

        int resG=0;
        int i=0,j=0;
        while(i<G && j<s.length()){
            while(s.charAt(j)!='G') j++;
            resG+=j-i;
            j++;
            i++;
        }
        int resB=0;
        i=0;
        j=0;

        while(i<B && j<s.length()){
            while(s.charAt(j)!='B') j++;
            resB+=j-i;
            j++;
            i++;
        }

        return Math.min(resB,resG);
    }

    public static void main(String[] args){
        Adjust_Queue s=new Adjust_Queue();
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            System.out.println(s.solve(str));
        }
    }
}
