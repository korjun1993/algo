package codetree.시뮬레이션.격자안에서터지고떨어지는경우;

import java.util.Arrays;
import java.util.Scanner;

public class 일차원젠가 {
	public static final int EMPTY = 0;
	public static int n, s1, e1, s2, e2;
	public static int[] board = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			board[i] = sc.nextInt();
		}
		s1 = sc.nextInt();
		e1 = sc.nextInt();
		move(s1, e1);

		s2 = sc.nextInt();
		e2 = sc.nextInt();
		move(s2, e2);

		// 출력
		System.out.println(n);

		for (int i = 0; i < n; i++) {
			System.out.println(board[i]);
		}
	}

	public static void move(int start, int end) {
		start--; end--;
		for (int i = start; i <= end; i++) {
			board[i] = EMPTY;
		}
		int[] temp = Arrays.copyOf(board, board.length);
		int endOfArray = 0;
		for (int i = 0; i < n; i++) {
			if (board[i] != EMPTY) {
				temp[endOfArray++] = board[i];
			}
		}

		for (int i = 0; i < endOfArray; i++) {
			board[i] = temp[i];
		}

		n = endOfArray;
	}
}
