package codetree.시뮬레이션.격자안에서밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 컨베이어벨트 {
	public static int n, t;
	public static int[] belt;

	public static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			t = Integer.parseInt(str[1]);
			belt = new int[2 * n];
			str = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				belt[i] = Integer.parseInt(str[i]);

			}
			str = br.readLine().split(" ");
			for (int i = n; i < 2 * n; i++) {
				belt[i] = Integer.parseInt(str[i - n]);

			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void circuit() {
		int temp = belt[2 * n - 1];
		for (int i = 2 * n - 2; i >= 0; i--) {
			belt[i + 1] = belt[i];
		}
		belt[0] = temp;
	}

	public static void solve() {
		for (int i = 0; i < t; i++) {
			circuit();
		}
		for (int i = 0; i < 2 * n; i++) {
			System.out.print(belt[i] + " ");
			if (i == n - 1) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}
