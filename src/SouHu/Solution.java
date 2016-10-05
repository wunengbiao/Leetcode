package SouHu;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2016/9/21.
 */
public class Solution {

    public int solve(String str,int m) {
        int n = str.length();

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = (int) (str.charAt(i)-'0');
            System.out.println(temp[i]+"---text---");
        }

        int[] results=new int[m];
        int count=0;

        for(int i=0;i<n;i++){
            int index=0;
            int max=-1;
            int j=i;
            for(j=i;j<n-m+2;j++){
                if(temp[j]>max){
                    max=temp[j];
                    index=j;
                }
            }
            temp[count++]=max;
            i=index+1;
            m--;
        }

        int sum=0;
        for(int i=0;i<results.length;i++){
            System.out.println("tem["+i+"]="+temp[i]);
            sum=sum*10+temp[i];
        }
       return sum;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int num=scanner.nextInt();
        Solution ss=new Solution();
        int ret=ss.solve(s,s.length()-num);
        System.out.println(ret);

    }
}
