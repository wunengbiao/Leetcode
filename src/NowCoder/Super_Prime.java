package NowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class Super_Prime {
    public void solve(int n){
        if(n<=3) System.out.println("No");
        else{
            boolean find=false;
            for(int p:getPrimes(n)){
                int q=(int)(Math.log(n)/Math.log(p));
                if(Math.pow(p,q)==n){
                    find=true;
                    System.out.println(p+" "+q);
                    break;
                }
            }
            if(!find){
                System.out.println("No");
            }
        }

    }

    public List<Integer> getPrimes(int n){
        List<Integer> list=new ArrayList<>();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Super_Prime s=new Super_Prime();
//        Scanner in=new Scanner(System.in);
//        int n=Integer.parseInt(in.nextLine());
        s.solve(25);
    }
}
