package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/7.
 */
public class Transform {
    public String trans(String s,int n){
        String[] strs=s.split(" ");
        String res="";
        for(int i=strs.length-1;i>=0;i--
                ){
            res+=reverse(strs[i]);
            res+=' ';
        }

        return res.substring(0,res.length()-1);

    }

    public String reverse(String str){
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>'Z'){
                chars[i]-=32;
            }else{
                chars[i]+=32;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args){
        Transform s=new Transform();
        Scanner in=new Scanner(System.in);
        String[] strs=in.nextLine().split(",");
        System.out.println(s.trans(strs[0],Integer.parseInt(strs[1])));
    }
}
