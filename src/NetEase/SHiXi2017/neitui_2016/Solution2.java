package NetEase.SHiXi2017.neitui_2016;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2017/3/9.
 */

/*
*
* [编程题] 地牢逃脱
给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
输入描述:
每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），表示地牢的长和宽。
接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。
接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，
左上角的坐标为 （0, 0），出发位置一定是 '.'）。之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，
接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）
* */
public class Solution2 {

    int px,py;//表示牛牛的位置
    int r,c;//表示地牢的行数和列数
    char[][] map;
    int k;
    int[] dx;
    int[] dy;

    public Solution2(int px, int py, int r, int c,char[][] map,int k,int[] dx,int[] dy) {
        this.px = px;
        this.py = py;
        this.r = r;
        this.c = c;
        this.map =map;
        this.k=k;
        this.dx=dx;
        this.dy=dy;
    }

    class Node{
        int i;
        int j;
        int length;

        public Node(int i,int j,int lenght){
            this.i=i;
            this.j=j;
            this.length=lenght;
        }
    }

    public boolean check(int i,int j){
        if(i>=0 && i<r && j>=0 && j<c && map[i][j]=='.')
            return true;
        return false;
    }

    public int solve(){
        Queue<Node> Q=new LinkedList<>();
        Node node=new Node(px,py,0);
        Q.offer(node);

        boolean[][] mark=new boolean[r][c];
        mark[px][py]=true;
        int max=Integer.MIN_VALUE;
        while(!Q.isEmpty()){
            Node cur=Q.poll();
            max=Math.max(cur.length,max);

            for(int i=0;i<k;i++){
                int nextX=cur.i+dx[i];
                int nextY=cur.j+dy[i];

                if(check(nextX,nextY) && !mark[nextX][nextY]){
                    Node G=new Node(nextX,nextY,cur.length+1);
                    Q.offer(G);
                    mark[nextX][nextY]=true;
                }
            }
        }

        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++){
                if(mark[i][j]==false && map[i][j]=='.')
                    return -1;
            }
        return max;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int r=scanner.nextInt();
            int c=scanner.nextInt();
            char[][] map=new char[r][c];

            for(int i=0;i<r;i++){
                String s=scanner.next();
                for(int j=0;j<c;j++){
                    map[i][j]=s.charAt(j);
                }
            }

            int px=scanner.nextInt();
            int py=scanner.nextInt();

            int k=scanner.nextInt();

            int[] dx=new int[k];
            int[] dy=new int[k];

            for(int i=0;i<k;i++){
                dx[i]=scanner.nextInt();
                dy[i]=scanner.nextInt();
            }

            Solution2 s=new Solution2(px,py,r,c,map,k,dx,dy);
            System.out.println(s.solve());
        }

    }
}
