package DD;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/21.
 */
public class Sum_of_Array {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n,sum,A[];
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        sum = cin.nextInt();
        A = new int[n];
        for(int i = 0; i < n ; i++){
            A[i] = cin.nextInt();
        }
        System.out.println(getTypeCount1(n,sum,A));
    }
    public static int getTypeCount1(int n, int sum, int[] A){
        int c[] = new int[sum+1];
        c[0] = 1;
        for(int i = 0;i < n; i++){
            int index = A[i];
            for(int j = sum; j >= 0; j--){
                if(j >= index && c[j-index]!=0 )
                    c[j] = c[j]+c[j-index];
            }
        }
        return c[sum];
    }

}
