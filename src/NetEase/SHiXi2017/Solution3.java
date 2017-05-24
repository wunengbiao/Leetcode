package NetEase.SHiXi2017;

import java.util.*;

/**
 * Created by wunengbiao on 2017/3/7.
 *
 * 每个测试输入包含1个测试用例
 * 第一行输入两个数字N，M表示地图的大小。其中0<N，M<=8。
 * 接下来有N行，每行包含M个字符表示该行地图。其中 . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
 * 每个地图必定包含1个玩家、1个箱子、1个目的地。
 */
public class Solution3 {

    int r;//地图的行数
    int c;//地图的列数
    int begx,begy;//箱子的开始位置
    int endx,endy;//目标坐标
    int begsx,begsy;//人开始的位置
    char map[][];
    int[] dx={-1,1,0,0};
    int[] dy={0,0,1,-1};
    char[] P={'N','S','E','W'};
    char[] M={'n','s','e','w'};

    Node f=new Node(0,0,0,0,"");
    Node g=new Node(0,0,0,0,"");

    Node1 F=new Node1(0,0,"");
    Node1 G=new Node1(0,0,"");

    int[][] mark;
    class Node1{
        int x;
        int y;
        String path;
        public Node1(int x,int y,String path){
            this.x=x;
            this.y=y;
            this.path=path;
        }
    }

    public Solution3(char[][] map,int r,int c,int begx,int begy,int endx,int endy,int begsx,int begsy){
        this.map=map;
        this.r=r;
        this.c=c;
        this.begx=begx;
        this.begy=begy;
        this.endx=endx;
        this.endy=endy;
        this.begsx=begsx;
        this.begsy=begsy;
        mark=new int[r][c];
    }

    class Node{
        int bx;
        int by;
        int px;
        int py;
        String path;

        public Node(int bx,int by,int px,int py,String path){
            this.bx=bx;
            this.by=by;
            this.px=px;
            this.py=py;
            this.path=path;
        }

    }

    public boolean ok(int x,int y){
        if(x>=0 && x<r && y>=0 && y<c) return true;
        return false;
    }

    public boolean SToB(int bx,int by,int ex, int ey) {//人到箱子BFS

        int[][] Mark1= new int[r][c];   //标志数组，表示地图上某一位置Mark1[i][j]是否访问过。

        Queue<Node1> P = new LinkedList<>();
        Mark1[bx][by] = 1;
        Mark1[f.bx][f.by] = 1;
        F.x = bx; F.y = by;
        F.path = "";
        if (bx == ex && by == ey) return true;//到达目标
        P.offer(new Node1(F.x,F.y,F.path));
        while (!P.isEmpty()) {
            F = P.poll();
            for (int i = 0; i < 4; ++i) {//向四个方向扩展
                G.x = F.x + dx[i];
                G.y = F.y + dy[i];
                if (!ok(G.x, G.y) || map[G.x][G.y] == '#') continue;
                if (Mark1[G.x][G.y]==0) {//此点没有访问过

                    Mark1[G.x][G.y] = 1;//标记为已访问
                    G.path = F.path + M[i];
                    if (G.x == ex && G.y == ey) {
                        F = G;
                        return true;
                    }
                    P.add(new Node1(G.x,G.y,G.path));

                }
            }
        }
        return false;
    }

    public boolean  bfs() {//箱子向目标bfs
        Queue<Node> Q = new LinkedList<Node>();
        f.bx = begx; f.by = begy;//f:人与箱子所在的位置
        f.px = begsx; f.py = begsy;
        f.path = "";
        mark[begx][begy] = 1;
        Q.offer(new Node(f.bx,f.by,f.px,f.py,f.path));
        while (!Q.isEmpty()) {
            f = Q.poll();//出队列
            for (int i = 0; i < 4; ++i) {//检查f的所有邻接点，向四个方向扩展
                int newx = f.bx + dx[i];
                int  newy = f.by + dy[i];//箱子前一位置
                int  tx = f.bx - dx[i];
                int  ty = f.by - dy[i];//箱子后一位置
                if (!ok(newx, newy) || map[newx][newy] == '#' || !ok(tx, ty)
                        || map[tx][ty] == '#' || mark[newx][newy]==1) continue;
                if (SToB(f.px, f.py, tx, ty)) {//检查人能否来
                    g.bx = newx; g.by = newy;
                    g.px = f.bx; g.py = f.by;
                    g.path = f.path + F.path + P[i];
                    if (g.bx == endx && g.by == endy)
                    {
                        return true;
                    }
                    mark[newx][newy] = 1;
                    Q.add(new Node(g.bx,g.by,g.px,g.py,g.path));
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

//        List<char[][]> maps=new ArrayList<>();
//        List<Integer> result=new ArrayList<>();
        int r=0;
        int c=0;
        String s="";
        int begx=0;
        int begy=0;
        int endx=0;
        int endy=0;
        int begsx=0;
        int begsy=0;
        char[][] map=null;
        int t=1;
        while(in.hasNext()){
//            if(in.next()==null) break;
            r=in.nextInt();
            c=in.nextInt();
            if(r==0&&c==0) break;
            map=new char[r][c];
            for(int i = 0; i <r; i++){
                s=in.next();
                for(int j=0;j< c;j++){
                    map[i][j]=s.charAt(j);
                    if (map[i][j] == '*') { begx = i; begy = j;}//箱子开始坐标
                    if (map[i][j] == '@') { endx = i; endy = j;}//目标坐标
                    if (map[i][j] == 'X')  { begsx = i;begsy = j;}//人开始坐标
                }

            }
            Solution3 ma=new Solution3(map,r,c,begx,begy,endx,endy,begsx,begsy);
            if (ma.bfs()) {
//                result.add(ma.g.path.length());
                System.out.println(ma.g.path.length());
            }
            else{
//                result.add(-1);
                System.out.println(-1);
            }

        }
//
//        for(Integer res:result){
//            System.out.print(res+" ");
//        }
    }
}
