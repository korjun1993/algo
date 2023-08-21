package codetree.백트래킹;

import java.util.Scanner;

public class 겹치지않게선분고르기 {
	static class Pair {
		int x1, x2;

		Pair(int x1, int x2) {
			this.x1 = x1;
			this.x2 = x2;
		}
	}

	static int n;
	static int answer;
	static Pair[] pairs;
	static int[] cnt = new int[1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			pairs[i] = new Pair(x1, x2);
		}
		solve(0, 0);
		System.out.println(answer);
	}

	public static void solve(int index, int count) {
		if (index == n) {
			if (validate()) {
				answer = Math.max(answer, count);
			}
			return;
		}
		solve(index + 1, count);
		check(pairs[0], 1);
		solve(index + 1, count + 1);
		check(pairs[0], -1);
	}

	public static void check(Pair pair, int value) {
		for (int i = pair.x1; i <= pair.x2; i++) {
			cnt[i] += value;
		}
	}

	public static boolean validate() {
		for (int i = 1; i <= 1000; i++) {
			if (cnt[i] == 2) {
				return false;
			}
		}
		return true;
	}
}
