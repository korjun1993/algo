package codetree.백트래킹;

import java.util.ArrayList;
import java.util.Scanner;

public class K개중에1개를n번뽑기 {
	public static int N, K;
	public static ArrayList<Integer> answer = new ArrayList<>();

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();

		choose(0);
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(answer.get(i) + " ");
		}
		System.out.println();
	}

	public static void choose(int curNum) {
		if (curNum == N) {
			print();
			return;
		}
		for (int number = 1; number <= K; number++) {
			answer.add(number);
			choose(curNum + 1);
			answer.remove(curNum);
		}
	}
}
