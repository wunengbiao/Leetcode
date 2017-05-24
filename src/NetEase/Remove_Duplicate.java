package NetEase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/4/13.
 */
public class Remove_Duplicate {
    public List<Integer> remove(int[] arr){
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(res.contains(arr[i])){
                res.remove((Object)arr[i]);
                res.add(arr[i]);
            }else{
                res.add(arr[i]);
            }
        }

        return res;
    }

    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        Remove_Duplicate s=new Remove_Duplicate();
        int[] arr;
        while(in.hasNext()){
            int nums=Integer.parseInt(in.nextLine());
            arr=new int[nums];
            for(int i=0;i<nums;i++){
                arr[i]=in.nextInt();
            }
            List<Integer> res=s.remove(arr);
            for(int i=0;i<res.size()-1;i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println(res.get(res.size()-1));
        }
    }
}
