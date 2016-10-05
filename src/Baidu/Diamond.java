package Baidu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by wunengbiao on 2016/9/24.
 */
public class Diamond {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			int maxNum = maxNumOfDiamon(line);
			System.out.println(maxNum + "");
		}
	}

	private static int maxNumOfDiamon(String line) {
		if (line == null || line.length() == 0) {
			return 0;
		}
		HashSet<Character> chMap = new HashSet<Character>();
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (ch >= 'A' && ch <= 'E') {
				chMap.add(ch);
			}
		}
		if (chMap.size() < 5) {
			return 0;
		}
		line += line;
		int n = line.length();
		int[] arr = new int[n];
        System.out.println(Arrays.toString(arr));
		for (int i = 0; i < 5; i++) {
			int last = -1;
			char cur = (char) ('A' + i);
			for (int j = 0; j < n; j++) {
				if (line.charAt(j) == cur) {
					last = j;
				}
				if (last == -1) {
					arr[j] = n;
				} else {
					arr[j] = Math.max(arr[j], j - last + 1);
				}
			}
			System.out.println(Arrays.toString(arr));
		}

		int res = n;
		for (int i = 0; i < n; i++) {
			res = Math.min(res, arr[i]);
		}
		return (n / 2) - res;
	}

}
