package QuanGuo;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/12.
 */
public class Sum_Seqence {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        String[] strs=in.nextLine().split(" ");
        int N=Integer.parseInt(strs[0]);
        int L=Integer.parseInt(strs[1]);

        int n=(int)Math.sqrt(N*2)+1;
        if(L>n){
            System.out.println("No");
            return;
        }

        boolean found=false;
        for(int l=L;l<=n && l<=100;l++){
            int mid=N/l;
            int left=N%l;
            if(l%2==1 && left==0){
                found=true;
                for(int s=mid-l/2;s<mid+l/2;s++){
                    System.out.print(s+" ");
                }
                System.out.println(mid+l/2);
                break;
            }

            if(l%2==0){
                if(left==l/2){
                    found=true;
                    for(int s=mid-l/2+1;s<mid+l/2;s++){
                        System.out.print(s+" ");
                    }
                    System.out.println(mid+l/2);
                    break;
                }
            }
        }

        if(!found) System.out.println("No");
    }
}
