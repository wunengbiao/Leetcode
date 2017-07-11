package Baidu;

import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by wunengbiao on 2017/6/19.
 */
public class Minmal_Brackets {
    public String result;
    public int min_cost;
    public int[][] coststable;
    public String line;

    public Minmal_Brackets(String line) {
        int unknown = 0;
        for (Character c : line.toCharArray()) {
            if (c == '?') unknown++;
        }
        this.result = "";
        this.min_cost = Integer.MAX_VALUE;
        this.coststable = new int[unknown][2];
        this.line=line;
    }

    public void solve() {
        if (line.length() % 2 == 1) min_cost = -1;
        else {
            helper(line, 0, 0, 0, coststable, 0, 0, "");
        }

    }

    public void helper(String s, int start, int left, int right, int[][] costs, int cost, int pos, String ss) {
        if (start == s.length()) {
            if (cost < min_cost) {
                result = ss;
                min_cost = cost;
            }
            return;
        }
        if (s.charAt(start) == '(') {
            if (left < s.length() / 2)
                helper(s, start + 1, left + 1, right, costs, cost, pos, ss + s.charAt(start));
        }
        else if (s.charAt(start) == ')') {
                if (right < s.length() / 2 && right < left)
                    helper(s, start + 1, left, right+1, costs, cost, pos, ss + s.charAt(start));
        } else {

                if (right < s.length() / 2 && right < left) {
                    helper(s, start + 1, left, right + 1, costs, cost + costs[pos][1], pos + 1, ss + ')');
                }

                if (left < s.length() / 2) {
                    helper(s, start + 1, left + 1, right, costs, cost + costs[pos][0], pos + 1, ss + '(');
                }
            }

    }

    public static void main(String[] args) {
        int y = 0;
        Scanner in = new Scanner(System.in);
        Minmal_Brackets s;
        while (in.hasNext()) {
            y++;
            String sequence = in.nextLine();
            s=new Minmal_Brackets(sequence);

            for (int i = 0; i < s.coststable.length; i++) {
                String[] nums = in.nextLine().split(" ");
                s.coststable[i][0] = Integer.parseInt(nums[0]);
                s.coststable[i][1] = Integer.parseInt(nums[1]);
            }

//            System.out.println("("+s.count_left+","+s.count_right+","+s.count_unkown+")");
//            System.out.println(y+":"+sequence.length());
            s.solve();


            System.out.println(y + ":" + s.min_cost);
            if (s.min_cost != -1) System.out.println(y + ":" + s.result);
//            System.out.println("-------------------------------");
        }
    }
}
