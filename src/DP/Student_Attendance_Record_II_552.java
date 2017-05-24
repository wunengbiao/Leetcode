package DP;

/**
 * Created by wunengbiao on 2017/5/8.
 *
 P(n) = A(n - 1) + P(n - 1) + L(n - 1), n ≥ 2.
 L(n) = A(n - 1) + P(n - 1) + A(n - 2) + P(n - 2), n ≥ 3.
 A(n) = A(n - 1) + A(n - 2) + A(n - 3), n ≥ 4.


 */
public class Student_Attendance_Record_II_552 {
    final int MOD=(int)1e9+7;
    public int checkRecord(int n) {
        if(n==1) return 3;
        int[] A=new int[n];
        int[] P=new int[n];
        int[] L=new int[n];

        P[0] = 1;
        L[0] = 1;
        L[1] = 3;
        A[0] = 1;
        A[1] = 2;
        if(n>=3)
        A[2] = 4;

        for(int i=1;i<n;i++){
            A[i-1]%=MOD;
            P[i-1]%=MOD;
            L[i-1]%=MOD;

            P[i]=((A[i-1]+P[i-1])%MOD+L[i-1])%MOD;
            if(i > 1) L[i] = ((A[i - 1] + P[i - 1]) % MOD + (A[i - 2] + P[i - 2]) % MOD) % MOD;
            if(i > 2) A[i] = ((A[i - 1] + A[i - 2]) % MOD + A[i - 3]) % MOD;
        }

        return ((A[n - 1] % MOD + P[n - 1] % MOD) % MOD + L[n - 1] % MOD) % MOD;
    }

    public static void main(String[] args){
        Student_Attendance_Record_II_552 s=new Student_Attendance_Record_II_552();
        System.out.println(s.checkRecord(10000));
    }
}
