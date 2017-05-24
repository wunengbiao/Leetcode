package NetEase;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/12.
 */
public class DoubleKernal {

    public int solve(int[] array){
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }

        int[] dp=new int[sum/2+1];

        for(int i=0;i<array.length;i++){
            for(int j=array[i];j<=sum/2;j++){
                dp[j]=Math.max(dp[j],dp[j-array[i]]+array[i]);
            }
//            for(int j = sum/2; j >= array[i]; --j) {
//                dp[j] = Math.max(dp[j], dp[j - array[i]] + array[i]);
//            }
        }
        return Math.max(dp[sum/2],sum-dp[sum/2]);
    }


    public static void main(String[] args){
        DoubleKernal s=new DoubleKernal();
        Scanner in =new Scanner(System.in);
        int[] array=null;
        while (in.hasNext()){
            int num=Integer.parseInt(in.nextLine());
            array=new int[num];
            String[] strs=in.nextLine().split(" ");

            for(int i=0;i<num;i++){
                array[i]=Integer.parseInt(strs[i])/1024;
            }

            System.out.println(s.solve(array)*1024);

        }
    }
}
