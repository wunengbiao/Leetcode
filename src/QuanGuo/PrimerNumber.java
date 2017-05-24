package QuanGuo;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/12.
 */
public class PrimerNumber {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());

        int p=0,q=0;
        for(q=2;q<=(int)Math.sqrt(n);q++){
            int pp=(int)Math.pow(n,1d/q);
            if((int)Math.pow(pp,q)==n && isPrime(pp)){
                p=pp;
                break;
            }
        }

        if(p==0)
            System.out.println("No");
        else System.out.println(p+" "+q);

    }

    public static boolean isPrime(int n){
        if(n==2) return true;
        int x=(int)Math.sqrt(n);
        for(int i=2;i<=x;i++){
            if(n%i==0) return false;
        }

        return true;
    }
}
