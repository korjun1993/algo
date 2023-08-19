package codetree.시뮬레이션.격자안에서터지고떨어지는경우;

import java.util.Scanner;

public class 단한번의2048시도 {
	public static int[][] board = new int[4][4];
	public static int[] dirMapper;
	public static char dir;
	public static final int EMPTY = 0;
	public static final int ASCII = 128;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		dir = sc.next().charAt(0);
		dirMapper = new int[ASCII];
		dirMapper['D'] = 0;
		dirMapper['R'] = 1;
		dirMapper['U'] = 2;
		dirMapper['L'] = 3;
		process();
		print();
	}

	public static void process() {
		// 90' 회전
		for (int i = 0; i < dirMapper[dir]; i++) {
			rotate();
		}

		downAndMerge();

		// 총 360' 회전
		for (int i = 0; i < 4 - dirMapper[dir]; i++) {
			rotate();
		}
	}

	// 오른쪽으로 90도 회전
	private static void rotate() {
		int[][] temp = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 0; j--) {
				temp[i][3 - j] = board[j][i];
			}
		}
		board = temp;
	}

	// 아래로 중력 적용 + 연속된 같은 숫자 병합
	private static void downAndMerge() {
		down();
		merge();
		down();
	}

	// 아래로 중력 적용
	private static void down() {
		int[][] temp = new int[4][4];
		for (int i = 0; i < 4; i++) {
			int endOfArray = 3;
			for (int j = 3; j >= 0; j--) {
				if (board[j][i] != EMPTY) {
					temp[endOfArray--][i] = board[j][i];
				}
			}
		}
		board = temp;
	}

	// 연속된 같은 숫자 병합
	private static void merge() {
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >= 1; j--) {
				if (board[j][i] == EMPTY) {
					continue;
				}
				if (board[j][i] == board[j - 1][i]) {
					board[j][i] *= 2;
					board[j - 1][i] = EMPTY;
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
