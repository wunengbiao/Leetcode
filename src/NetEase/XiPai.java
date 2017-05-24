package NetEase;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/3/10.
 */
public class XiPai {

    public void solve(int[] array,int nums){
        Stack<Integer> st=new Stack();
        for(int i=0;i<nums;i++){
            for(int j=array.length/2;j>0;j--){
                st.push(array[j-1+array.length/2]);
                st.push(array[j-1]);
            }

            int x=0;
            while(!st.isEmpty()) array[x++]=st.pop();
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        XiPai solve=new XiPai();
//        int[] arr={1,2,3,4,5,6};
//        solve.solve(arr,2);
//        System.out.println(Arrays.toString(arr));
        int[] array=null;
        int times=in.nextInt();
        int[][] result=new int[times][];
        for(int i=0;i<times;i++){
            int n=in.nextInt();
            int nums=in.nextInt();
            array=new int[n*2];

            for(int x=0;x<n*2;x++){
                array[x]=in.nextInt();
            }

            result[i]=new int[n*2];
            solve.solve(array,nums);
//            result[i]=Arrays.copyOf(array,n*2);
            result[i]=array;
        }

        for(int i=0;i<times;i++){
            for(int j=0;j<result[i].length-1;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println(result[i][result[i].length-1]);
        }
    }
}
