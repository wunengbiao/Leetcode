package DFS;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wunengbiao on 2017/6/27.
 */
public class Trapping_Rain_Water_II_407 {
    public class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

        public int trapRainWater(int[][] heights) {
            if(heights==null || heights.length==0 || heights[0].length==0) return 0;
            PriorityQueue<Cell> queue=new PriorityQueue<>(1, new Comparator<Cell>() {
                @Override
                public int compare(Cell o1, Cell o2) {
                    return o1.height-o2.height;
                }
            });

            int m=heights.length;
            int n=heights[0].length;

            boolean[][] visited=new boolean[m][n];
            for(int i=0;i<m;i++){
                visited[i][0]=true;
                visited[i][n-1]=true;
                queue.offer(new Cell(i,0,heights[i][0]));
                queue.offer(new Cell(i,n-1,heights[i][n-1]));
            }

            for(int i=0;i<n;i++){
                visited[0][i]=true;
                visited[m-1][i]=true;
                queue.offer(new Cell(0,i,heights[0][i]));
                queue.offer(new Cell(m-1,i,heights[m-1][i]));
            }
            int[][] dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int res=0;
            while(!queue.isEmpty()){
                Cell cell=queue.poll();
                for(int[] dir:dirs){
                    int row=cell.row+dir[0];
                    int col=cell.col+dir[1];
                    if(row>=0 && row<m && col>=0 && col<n && !visited[row][col]){
                        visited[row][col]=true;
                        res+=Math.max(0,cell.height-heights[row][col]);
                        queue.offer(new Cell(row,col,Math.max(heights[row][col],cell.height)));
                    }
                }
            }
            return res;
        }

        public static void main(String[] args){
            Trapping_Rain_Water_II_407 s=new Trapping_Rain_Water_II_407();
            int[][] heights={
                    {1,4,3,1,3,2},
                    {3,2,1,3,2,4},
                    {2,3,3,2,3,1}
            };
            System.out.println(s.trapRainWater(heights));
        }
}
