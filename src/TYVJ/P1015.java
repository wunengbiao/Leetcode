package TYVJ;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/17.
 */
public class P1015 {
    public int solve(int[] array,int n){
        int x=n/10;
        int y=n%10;
        return array[9]*x+array[y-1];
    }

    public void compute(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=0;j<i;j++){
                array[i]=Math.min(array[i],array[j]+array[i-j-1]);
            }
        }
    }

    public static void main(String[] args){
        P1015 s=new P1015();
        int[] array=new int[10];
        Scanner in=new Scanner(System.in);
        String[] line=in.nextLine().split(" ");
        for(int i=0;i<10;i++){
            array[i]=Integer.parseInt(line[i]);
        }
        int n=Integer.parseInt(in.nextLine());
        s.compute(array);
        System.out.println(s.solve(array,n));
    }
}
