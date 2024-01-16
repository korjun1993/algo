package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15651_N과M3 {
	static int n, size;
	static int[] selected;

	public static void solve(int index) {
		if (index >= size) {
			for (int number : selected) {
				System.out.print(number + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			selected[index] = i;
			solve(index + 1);
			selected[index] = 0;
		}
	}

	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		size = Integer.parseInt(in[1]);
		selected = new int[size];
	}

	public static void main(String[] args) throws Exception {
		input();
		solve(0);
	}
}
