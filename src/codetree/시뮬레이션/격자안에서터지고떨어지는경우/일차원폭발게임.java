package codetree.시뮬레이션.격자안에서터지고떨어지는경우;

import java.util.Arrays;
import java.util.Scanner;

public class 일차원폭발게임 {
	public static final int EMPTY = 0;
	public static int N, M;
	public static int[] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N];

		for (int i = 0; i < N; i++) {
			board[i] = sc.nextInt();
		}

		while (isBoom()) {
			boom();
		}

		print();
	}

	public static void boom() {
		int[] temp = new int[N];
		int endOfArray = N - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (board[i] != EMPTY) {
				temp[endOfArray--] = board[i];
			}
		}

		for (int i = 0; i < N; i++) {
			board[i] = temp[i];
		}
	}

	public static boolean isBoom() {
		boolean result = false;
		int count = 1;

		for (int i = 1; i < N; i++) {
			if (board[i] == EMPTY) {
				continue;
			}
			if (board[i] == board[i - 1]) {
				count++;
			} else if (count >= M) {
				Arrays.fill(board, i - count, i, EMPTY);
				count = 1;
				result = true;
			} else {
				count = 1;
			}
		}

		if (count >= M && board[N - 1] != EMPTY) {
			Arrays.fill(board, N - count, N, EMPTY);
			result = true;
		}

		return result;
	}

	public static void print() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (board[i] != EMPTY) {
				count++;
				sb.append(board[i]).append('\n');
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
