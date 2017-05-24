package Tecent;

/**
 * Created by wunengbiao on 2017/3/17.
 *
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，
 * 某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。
 * 写出具体算法思路和代码实现，要求算法尽可能高效。
   给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
   若没有金额超过总数的一半，返回0。
   测试样例：
   [1,2,3,2,2],5
   返回：2
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        int median=(int) Math.floor(n/2);
        int value=QuickSort(gifts,0,n-1,median);
        int count=0;
        for(int i=0;i<n;i++){
            if(gifts[i]==value) count++;
        }

        return count>n/2?value:0;
    }

    public int QuickSort(int[] gifts,int start,int end,int k){
        if(start==k) return gifts[start];
        int i=start;
        int j=end;
        int key=gifts[end];

        while(i<=j){
            while(i<=j && gifts[i]<key) i++;
            gifts[j]=gifts[i];
            while(i<=j && key<gifts[j]) j--;
            gifts[i]=gifts[j];
        }
        gifts[i]=key;

        if(k<i) return QuickSort(gifts,start,i-1,k);
        else return QuickSort(gifts,i,end,k);
    }

    public static void main(String[] args){
        Gift gift=new Gift();
        System.out.println((int)Math.floor(5/2));
        int[] array={1,2,2,2,3};
        System.out.println(gift.getValue(array,5));
    }
}
