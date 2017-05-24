package QuanGuo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/12.
 */
public class YeMa {

    static int[] p=new int[10];

    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        int nums=Integer.parseInt(in.nextLine());

        for(int i=1;i<=nums;i++){
            parse_num(i);
        }

        for(int i=0;i<9;i++){
            System.out.print(p[i]+" ");
        }
        System.out.println(p[9]);

    }

    public static void parse_num(int num){
        while(num!=0){
            p[num%10]++;
            num/=10;
        }
    }
}
