package SouHu;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2016/9/24.
 */
public class BinaryMax {

    public static int solve(int m){
        String str=Integer.toBinaryString(m);
        String bits_str='0'+str;
//        System.out.println(bits_str);

        char[] bits=bits_str.toCharArray();
        int n=bits.length;

        int index0=n;
        int index1=n;
        for(int i=n-1;i>0;i--){
            if(bits[i]=='1'){
                index1=i;
                break;
            }
        }

        for(int i=index1-1;i>=0;i--){
            if(bits[i]=='0'){
                index0=i;
                break;
            }
        }

//        System.out.println("index0:"+index0);
//        System.out.println("index1:"+index1);

        for(int pos=index0;pos<index1;pos++){
            bits[pos]=bits[pos+1];
        }
        bits[index1]='0';

        String data=String.valueOf(bits);
//        System.out.println(data);

        int ret=Integer.parseInt(data,2);
        return ret;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int ret=solve(m);
        System.out.println(ret);

    }
}
