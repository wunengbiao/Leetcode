package NetEase.SHiXi2017.neitui_2016;

import java.util.*;

/**
 * Created by wunengbiao on 2017/3/9.
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，
 * 其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，
 * 顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
   输入描述:
   每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），
   接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
 */
public class Solution8 {

    public int get(int[] array){
        int n=array.length;
        int k=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(array[i]>array[j])
                    k++;
            }
        }

        return k;
    }

    List<List<Integer>> full= new ArrayList();
    public void permutation(Integer[] array,int k,int n){

        if(k==n){
            full.add(new ArrayList<>(Arrays.asList(array)));
        }else{
            for(int i=k;i<=n;i++){
                Integer temp=array[i];
                array[i]=array[k];
                array[k]=temp;
                permutation(array,k+1,n);

                Integer temp2=array[i];
                array[i]=array[k];
                array[k]=temp2;
            }
        }
    }

    public int solve(int[] array,int k){
        int count=0;
        List<Integer> position=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i]==0) position.add(i);
        }

        Integer[] NoIn=new Integer[position.size()];

        Set<Integer> s=new HashSet();
        for(int i=0;i<array.length;i++){
            s.add(array[i]);
        }

        int j=0;
        for(int i=1;i<=array.length;i++){
            if(!s.contains(i))
                NoIn[j++]=i;
        }

        permutation(NoIn,0,position.size()-1);

        for(List<Integer> arr:full){
            int i=0;
            for(Integer pos:position){
                array[pos]=arr.get(i++);
            }

//            System.out.println(Arrays.toString(array));
            if(get(array)==k) count++;
        }

        return count;
    }

    public static void main(String[] args){
        Solution8 s=new Solution8();
        Scanner in=new Scanner(System.in);
        int[] array=null;
        while(in.hasNext()){
            int n=in.nextInt();
            int k=in.nextInt();
            array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=in.nextInt();
            }

            System.out.println(s.solve(array,k));
        }
    }
}
