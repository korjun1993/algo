package codetree.백트래킹;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 특정조건에맞게K개중에1개를N번뽑기 {
	public static int k, n;
	public static List<Integer> select = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();

		solve(0);
	}

	private static void solve(int index) {
		if (index == n) {
			print();
			return;
		}

		for (int i = 1; i <= k; i++) {
			if (validate(index, i)) {
				select.add(index, i);
				solve(index + 1);
				select.remove(index);
			}
		}
	}

	private static boolean validate(int index, int num) {
		if (index >= 2 && select.get(index - 2) == select.get(index - 1) && select.get(index - 1) == num) {
			return false;
		}
		return true;
	}

	private static void print() {
		for (int num : select) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
