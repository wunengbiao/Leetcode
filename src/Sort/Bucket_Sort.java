package Sort;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/26.
 */
public class Bucket_Sort {

    public void sort(int[] num){

        int max=num[0];
        for(int i=1;i<num.length;i++){
            if(num[i]>max) max=num[i];
        }

        int[] tmp=new int[num.length];

        int exp=1;
        while(max/exp>0){
            int[] count=new int[10];

            for(int i=0;i<num.length;i++){
                count[num[i]/exp%10]++;
            }

            for(int i=1;i<count.length;i++){
                count[i]+=count[i-1];
            }

            for(int i=num.length-1;i>=0;i--){
                tmp[--count[num[i]/exp%10]]=num[i];
            }

            for(int i=0;i<num.length;i++){
                num[i]=tmp[i];
            }

            exp*=10;
        }
    }

    public static void main(String[] args){
        Bucket_Sort sort=new Bucket_Sort();
        int[] nums={1,3,2,4,34,23,56,78,89,56,34,23,21,43,56,67,87,90};
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
