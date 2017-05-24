package NetEase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/18.
 */
public class ShengJi {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        while(in.hasNext()){
            int nums=in.nextInt();
            int ability=in.nextInt();
            for(int i=0;i<nums;i++){
                int demon=in.nextInt();
                if(ability>=demon) ability+=demon;
                else ability+=gcd(ability,demon);
            }
            System.out.println(ability);
        }

    }

    public static int gcd(int a,int b){
        while(b!=0){
            int tmp=b;
            b=a%b;
            a=tmp;
        }

        return a;
    }

}
