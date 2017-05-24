package Others;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/10.
 */
public class Max_Sub_Increase_Seq_II {

    public void longest_sub_increase_seq(int[] array){
        int n=array.length;
        if(n==0) return;

        int[] S=new int[n];
        int max_value=1;
        int max_value_id=0;
        S[0]=1;

        int[] Q=new int[n+1];
        for(int i=1;i<=n;i++) Q[i]=Integer.MAX_VALUE;
        Q[1]=array[0];

        for(int i=1;i<n;i++){
            int j=find_bin(Q,1,n,array[i]);
            Q[j]=array[i];
            S[i]=j;

            if(max_value<S[i]){
                max_value=S[i];
                max_value_id=i;
            }
        }

        System.out.println("Max Length:"+max_value);
        System.out.println(Arrays.toString(S));

        int i=max_value_id;
        System.out.println(i);
        while(S[i]>1){
            System.out.print(array[i]+"->");
            for(int r=0;r<i;r++){
                if(S[r]+1==S[i] && array[r]<array[i]){
                    i=r;
                    break;
                }
            }
        }
        System.out.print(array[i]);


    }

    private int find_bin(int[] arr,int start,int end,int key){
        System.out.println(Arrays.toString(arr));
        while(start<=end){
            int mid=start+(end-start)/2;
            if(key>arr[mid])
                start=mid+1;
            else if(key<arr[mid])
                end=mid-1;
            else return mid;
        }

        return start;
    }

    public static void main(String[] args){
        Max_Sub_Increase_Seq_II s=new Max_Sub_Increase_Seq_II();
        int[] array={10,22,9,33,21,50,41,60,80};
        s.longest_sub_increase_seq(array);
    }

}
