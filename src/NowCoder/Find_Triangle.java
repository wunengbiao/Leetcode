package NowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/6/6.
 */
public class Find_Triangle {
    public double solve(List<int[]> R,List<int[]> G,List<int[]> B){
        double max=0;

        if(R.size()>=3){
            for(int i=0;i<R.size()-2;i++){
                for(int j=i+1;j<R.size()-1;j++){
                    for(int z=j+1;z<R.size();z++){
                        max=Math.max(max,getArea(R.get(i),R.get(j),R.get(z)));
                    }
                }
            }
        }

        if(G.size()>=3){
            for(int i=0;i<G.size()-2;i++){
                for(int j=i+1;j<G.size()-1;j++){
                    for(int z=j+1;z<G.size();z++){
                        max=Math.max(max,getArea(G.get(i),R.get(j),G.get(z)));
                    }
                }
            }
        }

        if(B.size()>=3){
            for(int i=0;i<B.size()-2;i++){
                for(int j=i+1;j<B.size()-1;j++){
                    for(int z=j+1;z<B.size();z++){
                        max=Math.max(max,getArea(B.get(i),R.get(j),B.get(z)));
                    }
                }
            }
        }

        if(R.size()>0 && G.size()>0 && B.size()>0){
            for(int i=0;i<R.size();i++){
                for(int j=0;j<G.size();j++){
                    for(int z=0;z<B.size();z++){
                        max=Math.max(max,getArea(R.get(i),G.get(j),B.get(z)));
                    }
                }
            }
        }

        return max;
    }

    public double getArea(int[] p1,int[] p2,int[] p3){
        double edge1=Math.sqrt(Math.pow(p2[0]-p1[0],2)+Math.pow(p2[1]-p1[1],2)+Math.pow(p2[2]-p1[2],2));
        double edge2=Math.sqrt(Math.pow(p3[0]-p2[0],2)+Math.pow(p3[1]-p2[1],2)+Math.pow(p3[2]-p2[2],2));
        double edge3=Math.sqrt(Math.pow(p3[0]-p1[0],2)+Math.pow(p3[1]-p1[1],2)+Math.pow(p3[2]-p1[2],2));

        if(edge1+edge2>edge3 && edge1+edge3>edge2 && edge2+edge3>edge1){
            double p=(edge1+edge2+edge3)/2;
            return Math.sqrt(p*(p-edge1)*(p-edge2)*(p-edge3));
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        Find_Triangle s=new Find_Triangle();
        Scanner in=new Scanner(System.in);

        List<int[]> R=new ArrayList<>();
        List<int[]> G=new ArrayList<>();
        List<int[]> B=new ArrayList<>();

        int n=Integer.parseInt(in.nextLine());

        for(int i=0;i<n;i++){
            int[] point=new int[3];
            String[] strs=in.nextLine().split(" ");
            point[0]=Integer.parseInt(strs[1]);
            point[1]=Integer.parseInt(strs[2]);
            point[2]=Integer.parseInt(strs[3]);
            if(strs[0].equals("R")){
                R.add(point);
            }
            else if(strs[0].equals("G")){
                G.add(point);
            }else{
                B.add(point);
            }
        }

        System.out.printf("%.5f\n",s.solve(R,G,B));
    }
}
