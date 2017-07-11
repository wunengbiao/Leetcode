package NowCoder;

import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/5/31.
 */
public class Sum_of_Series {
    public void solve(int n,int L){
        int end=(int)Math.sqrt(2*n)+1;

        int start=-1;
        int length=-1;

        for(int i=L;i<=Math.min(end,100);i++){
            int average=n/i;
            if((i & 1)==1){
                if(average-(i-1)/2>=0 && n%i==0){
                    start=average-(i-1)/2;
                    length=i;
                    break;
                }
            }else{
                int left=n%i;
                if(left==i/2 && average-(i/2-1)>=0){
                    start=average-(i/2-1);
                    length=i;
                    break;
                }
            }
        }

        System.out.println("start:"+start);
        System.out.println("length:"+length);
        if(length!=-1){
            for(int i=0;i<length-1;i++) System.out.print(start+i+" ");
            System.out.println(start+length-1);
        }else{
            System.out.println("No");
        }
    }
    public static void main(String[] args){
        Sum_of_Series s=new Sum_of_Series();
        Scanner in=new Scanner(System.in);
        String[] nums=in.nextLine().split(" ");
        s.solve(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));

    }
}
