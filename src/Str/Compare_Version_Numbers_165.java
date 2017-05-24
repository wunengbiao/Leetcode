package Str;

import java.util.Map;

/**
 * Created by wunengbiao on 2017/3/21.
 */
public class Compare_Version_Numbers_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");

        int l1=v1.length;
        int l2=v2.length;
        int i=0;
        int end= Math.max(l1,l2);
        while(i<end){
            int num1=(i>=l1)?0:Integer.parseInt(v1[i]);
            int num2=(i>=l2)?0:Integer.parseInt(v2[i]);
            if(num1==num2){
                i++;
                continue;
            }else{
                return num1>num2?1:-1;
            }

        }
        return 0;
    }

    public static void main(String[] args){
        Compare_Version_Numbers_165 solution=new Compare_Version_Numbers_165();
        System.out.println(solution.compareVersion("1.0","1"));
    }
}
