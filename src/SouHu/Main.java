package SouHu;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	private static int height = 0;
	private static int max_height = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int num_node = sc.nextInt();
			int[][] nodes = new int[num_node][2];
			for(int i=0;i<num_node-1;i++){
				nodes[i][0] = sc.nextInt();
				nodes[i][1] = sc.nextInt();
			}
			solution(nodes,num_node);
			System.out.println(max_height+1);
		}
	}

	private static void solution(int[][] nodes, int num_node) {
		HashSet<Integer> child_set = new HashSet<Integer>();
		HashSet<Integer> father_set = new HashSet<Integer>();
		for(int i=0;i<num_node;i++){
			father_set.add(nodes[i][0]);
			child_set.add(nodes[i][1]);
		}


		HashSet<Integer> father_set_copy = new HashSet<>();
		father_set_copy.addAll(father_set);
		for(Integer father:father_set_copy){
			if(child_set.contains(father)){
				child_set.remove(father);
				father_set.remove(father);
			}
		}

		System.out.println(child_set);
        System.out.println(father_set);

		int index_father = 0;
		for(Integer father:father_set)
			index_father = father;

		for(Integer child:child_set){
			dfs(child,nodes,num_node,index_father);
		}
	}

	private static void dfs(Integer child, int[][] nodes,int num_node,int father) {
		if(child == father){
			if(max_height < height){
				max_height = height;
			}
			height=0;
			return;
		}
		for(int i=0;i<num_node;i++){
			if(nodes[i][1]==child){
				height++;
				dfs(nodes[i][0],nodes,num_node,father);
			}
		}

	}

}
