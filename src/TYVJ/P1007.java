package TYVJ;

import java.util.*;

/**
 * Created by wunengbiao on 2017/4/16.
 */
public class P1007 {
    List<Integer> K=new ArrayList<>();
    List<Integer> L=new ArrayList<>();

    public void solve(int M,int N,int k,int l,int[][] positions){

        Map<Integer,Integer> kMap=new HashMap<>();
        Map<Integer,Integer> lMap=new HashMap<>();
        for(int i=0;i<positions.length;i++){
            if(positions[i][1]==positions[i][3]){
                int key=Math.min(positions[i][0],positions[i][2]);
                if(kMap.containsKey(key)){
                    int tmp=kMap.get(key)+1;
                    kMap.put(key,tmp);
                }else{
                    kMap.put(key,1);
                }
            }else{
                int key=Math.min(positions[i][1],positions[i][3]);
                if(lMap.containsKey(key)){
                    int tmp=lMap.get(key)+1;
                    lMap.put(key,tmp);
                }else{
                    lMap.put(key,1);
                }
            }
        }

        Comparator cmp=new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Integer,Integer>> kHeap=new PriorityQueue<>(cmp);
        kHeap.addAll(kMap.entrySet());

        PriorityQueue<Map.Entry<Integer,Integer>> lHeap=new PriorityQueue<>(cmp);
        lHeap.addAll(lMap.entrySet());

        while(k>0 && l>0){
            if(lHeap.peek().getValue()>kHeap.peek().getValue()){
                L.add(lHeap.peek().getKey());
                lHeap.poll();
                l--;
            }else{
                K.add(lHeap.peek().getKey());
                kHeap.poll();
                k--;
            }
        }

        while(k>0){
            K.add(lHeap.peek().getKey());
            kHeap.poll();
            k--;
        }

        while(l>0){
            L.add(lHeap.peek().getKey());
            lHeap.poll();
            l--;
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        P1007 s=new P1007();

        String[] line=in.nextLine().split(" ");
        int M=Integer.parseInt(line[0]);
        int N=Integer.parseInt(line[1]);
        int k=Integer.parseInt(line[2]);
        int l=Integer.parseInt(line[3]);
        int D=Integer.parseInt(line[4]);

        int[][] positions=new int[D][4];
        for(int i=0;i<D;i++){
            positions[i][0]=in.nextInt();
            positions[i][1]=in.nextInt();
            positions[i][2]=in.nextInt();
            positions[i][3]=in.nextInt();
        }

        s.solve(M,N,k,l,positions);
        for(int i=0;i<k-1;i++){
            System.out.print(s.K.get(i)+" ");
        }
        System.out.println(s.K.get(k-1));

        for(int i=0;i<l-1;i++){
            System.out.print(s.L.get(i)+" ");
        }
        System.out.println(s.L.get(l-1));

    }
}
