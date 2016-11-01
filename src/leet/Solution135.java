package leet;

import Base.IntPrintUtil;

/**
 * Created by wunengbiao on 2016/10/22.
 */
public class Solution135 {
    IntPrintUtil utils=new IntPrintUtil();
    public int candy(int[] ratings) {
       Integer[] a=new Integer[ratings.length];
        for(int i=0;i<ratings.length;i++){
            a[i]=1;
        }

        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) a[i]=a[i-1]+1;
        }

        utils.print(a);
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && a[i]<a[i+1]+1) a[i]=a[i+1]+1;
        }
        utils.print(a);
        int sum=0;
        for(int i=0;i<ratings.length;i++){
            sum+=a[i];
        }
        return sum;
    }

    public static void main(String[] args){
//        int a[]={1,2,4,3,2,1,0,4,5,6,7};
        int a[]={2,1};
        Solution135 s=new Solution135();
        System.out.println(s.candy(a));
    }

}
