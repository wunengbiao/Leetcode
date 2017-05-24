package Tecent;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/17.
 *
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
 * 请编写一个函数，使用递归的方法生成N位的格雷码。
   给定一个整数n，请返回n位的格雷码，顺序为从0开始。
   测试样例：
   1
   返回：["0","1"]
 */
public class GrayCode {

    public String[] getGray(int n) {
        int size=(int)Math.pow(2,n);
        String[] result=new String[size];

        if(n==1){
            result[0]="0";
            result[1]="1";
            return result;
        }

        String[] temp=getGray(n-1);
        for(int i=0;i<temp.length;i++){
            result[i]='0'+temp[i];
        }
        for(int i=temp.length;i<size;i++){
            result[i]='1'+temp[size-i-1];
        }

        return result;
    }

    public static void main(String[] args){
        GrayCode grayCode=new GrayCode();
        System.out.println(Arrays.toString(grayCode.getGray(20)));
    }

}
