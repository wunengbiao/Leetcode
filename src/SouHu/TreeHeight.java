package SouHu;

import java.util.*;

/**
 * Created by wunengbiao on 2016/9/23.
 */
public class TreeHeight {

    static int max_height=1;

    static List<List<Integer>> lists= new ArrayList<>();

    public static void processData(int[][] tree,int count){
        for(int i=0;i<count;i++)
            lists.add(new ArrayList<Integer>());
        int len=tree.length;
        for(int i=0;i<len;i++){
            int parent=tree[i][0];
            List list=lists.get(parent);
            list.add(tree[i][1]);
        }

    }

    public static void dfs(int root,int cur){

        List<Integer> child=lists.get(root);
        if(child.size()==0){
            if(cur>max_height)
                max_height=cur;
            return;
        }else{
            for(int i:child){
                dfs(i,++cur);
            }
        }
    }

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
			int num_node = scanner.nextInt();
			int[][] nodes = new int[num_node-1][2];
			for(int i=0;i<num_node-1;i++){
				nodes[i][0] = scanner.nextInt();
				nodes[i][1] = scanner.nextInt();
			}
			processData(nodes,num_node);
            dfs(0,0);
			System.out.println(max_height);
		}
    }

}
