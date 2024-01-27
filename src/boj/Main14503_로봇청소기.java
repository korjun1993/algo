package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503_로봇청소기 {
	public static int H, W, Answer;
	public static int row, col, dir;
	public static int[][] map;
	public static boolean[][] clean;
	public static final int[] dx = {0, 1, 0, -1};
	public static final int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		clean = new boolean[H][W];
		Answer = 0;

		st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (row >= 0 && row < H && col >= 0 && col < W && map[row][col] != 1) {
			move();
		}

		System.out.println(Answer);
		br.close();
	}// main

	private static void move() {
		// 1. 청소
		if (!clean[row][col]) {
			clean[row][col] = true;
			Answer++;
		}

		// 2. 좌측으로 4번 탐색
		int nextRow, nextCol, nextDir;
		for (int i = 1; i <= 4; i++) {
			nextDir = dir - i;
			if (nextDir < 0)
				nextDir += 4;
			nextRow = row + dy[nextDir];
			nextCol = col + dx[nextDir];

			// 벽이 아니면서 청소하지 않았으면 이동
			if (nextRow >= 0 && nextRow < H && nextCol >= 0 && nextCol < W && map[nextRow][nextCol] == 0
				&& !clean[nextRow][nextCol]) {
				row = nextRow;
				col = nextCol;
				dir = nextDir;
				return;
			}
		}

		// 3. 후진
		row -= dy[dir];
		col -= dx[dir];
	}
}
