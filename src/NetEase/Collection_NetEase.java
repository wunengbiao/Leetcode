package NetEase;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by wunengbiao on 2017/4/13.
 */
public class Collection_NetEase {
    public class Pair {
        int a;
        int b;

        Pair(int a, int b) {

            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {

            return this.a == ((Pair) obj).a && this.b == ((Pair) obj).b;
        }

        @Override
        public int hashCode() {
            return a*b;
        }
    }

    public int gcd(int x,int y){
        if(x<y){
            int tmp=x;
            x=y;
            y=tmp;
        }

        while(y!=0){
            int tmp=x%y;
            x=y;
            y=tmp;
        }
        return x;
    }
    public int solve(int w,int x,int y,int z){
        Set<Pair> set=new HashSet<>();
        for(int i=w;i<=x;i++){
            for(int j=y;j<=z;j++){
                Pair p=new Pair(i/gcd(i,j),j/gcd(i,j));
                if(!set.contains(p)){
                    set.add(p);
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args){
        Collection_NetEase s=new Collection_NetEase();
        Scanner in=new Scanner(System.in);

        while(in.hasNext()){
            String[] line=in.nextLine().split(" ");
            int w=Integer.parseInt(line[0]);
            int x=Integer.parseInt(line[1]);
            int y=Integer.parseInt(line[2]);
            int z=Integer.parseInt(line[3]);

            System.out.println(s.solve(w,x,y,z));
        }
    }
}
