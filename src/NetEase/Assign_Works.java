package NetEase;

import java.util.*;

/**
 * Created by wunengbiao on 2017/4/13.
 */
public class Assign_Works {
    int res=0;
    int[] b=new int[6];

    public void dfs(List<String> list, int i){
        System.out.println(Arrays.toString(b));
       if(i==list.size()){
           res++;
           return;
       }

       for(Character c:list.get(i).toCharArray()){
           if(b[c-'0']==1){
               b[c-'0']=0;
               dfs(list,i+1);
               b[c-'0']=1;
           }
       }
    }

    public static void main(String[] args){
        Assign_Works s=new Assign_Works();
        Scanner in=new Scanner(System.in);
        List<String> list=new ArrayList<>();
        while (in.hasNext()){

            int n=Integer.parseInt(in.nextLine());

            for(int i=0;i<n;i++){
                String line=in.nextLine();
                list.add(line);
            }

            Arrays.fill(s.b,1);
            s.dfs(list,0);
            System.out.println(s.res);
        }




    }
}
