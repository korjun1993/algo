package programmers;

import java.util.Arrays;

public class Solution_최댓값과최솟값 {
	public String solution(String s) {
		int[] num = mapToInt(s);
		int min = min(num);
		int max = max(num);
		return min + " " + max;
	}

	public int[] mapToInt(String s) {
		return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	public int min(int[] num) {
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			if (num[i] < minValue) {
				minValue = num[i];
			}
		}
		return minValue;
	}

	public int max(int[] num) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			if (num[i] > maxValue) {
				maxValue = num[i];
			}
		}
		return maxValue;
	}
}
