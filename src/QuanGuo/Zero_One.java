package QuanGuo;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/3/12.
 *
 * 牛牛正在挑战一款名为01翻转的游戏。游戏初始有A个0,B个1，牛牛的目标就是把所有的值都变为1，
 * 每次操作牛牛可以任意选择恰好K个数字，并将这K个数字的值进行翻转(0变为1，1变为0)。
 * 牛牛如果使用最少的操作次数完成这个游戏就可以获得奖品，牛牛想知道最少的操作次数是多少？
   例如:A = 4 B = 0 K = 3
   0000 -> 1110 -> 1001 -> 0100 -> 1111
   需要的最少操作次数为4
   输入描述:
   输入为一行：
   一共三个整数A(0 ≤ A ≤ 100,000),B(0 ≤ B ≤ 100,000),K(1 ≤ K ≤100,000).以空格分隔


   输出描述:
   输出一个整数，表示最少需要的操作次数。如果不能完成，则输出-1
 */
public class Zero_One {
    public int solve(int a,int sum,int k){
        if(a==0) return 0;

        for(int i=1;i<=sum;i++){
            int mx=i*k;

            if(mx<a) continue;
            int rest=mx-a;
            if(rest%2==1) continue;

            int use=(sum-a)*(i/2);
            use+=a*((i-1)/2);
            use*=2;
            if(rest<=use) return i;
        }

        return -1;
    }

    public static void main(String[] args){
        Zero_One s=new Zero_One();
        System.out.println(s.solve(4,4,3));
    }

}