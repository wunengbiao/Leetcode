package lintCode;

/**
 * Created by wunengbiao on 2017/4/4.
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。
 * 每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
 * 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。
 *
 *
 * 样例
 * costs = [[14,2,11],[11,14,5],[14,3,10]] return 10
 * 房屋 0 蓝色, 房屋 1 绿色, 房屋 2 蓝色， 2 + 5 + 3 = 10
 */
public class ColorRoom {
    public int minCostII(int[][] costs) {
        if(costs.length==0) return 0;
        int n=costs.length;
        for(int i=1;i<costs.length;i++){
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(Math.min(costs[n-1][0],costs[n-1][1]),costs[n-1][2]);
    }

    public static void main(String[] args){
        ColorRoom s=new ColorRoom();
        int[][] costs={{7,14,9,12},{10,14,2,9},{5,9,7,9},{5,6,17,6},{9,14,9,17},{1,17,17,5},{15,16,11,15},{5,19,15,1},{19,1,17,6},{9,8,9,6},{8,11,6,1},{11,7,18,8},{4,5,18,7},{15,18,19,12},{1,12,13,10},{18,3,14,17}};
        System.out.println(s.minCostII(costs));
    }
}
