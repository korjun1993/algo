package codetree.격자안에서밀고당기기;

import java.util.Scanner;

public class 삼각형컨베이어벨트 {
	public static int n, t;
	public static int[] belt;
	public static int SIZE;

	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		t = sc.nextInt();
		SIZE = 3 * n;
		belt = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			belt[i] = sc.nextInt();
		}
	}

	public static void solve() {
		for (int i = 0; i < t; i++) {
			int temp = belt[SIZE - 1];
			for (int j = SIZE - 2; j >= 0; j--) {
				belt[j + 1] = belt[j];
			}
			belt[0] = temp;
		}

		for (int i = 0; i < SIZE; i++) {
			System.out.print(belt[i] + " ");
			if (i % n == n - 1) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		input();
		solve();
	}
}
