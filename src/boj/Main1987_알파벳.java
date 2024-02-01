package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1987_알파벳 {

	static int R, C;
	static char[][] map;
	static boolean[] visit;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int Answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);

		map = new char[R][C];
		visit = new boolean[26];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visit[map[0][0] - 'A'] = true;
		dfs(0, 0 , 1);
		System.out.println(Answer);
	}

	private static void dfs(int row, int col, int cnt) {
		
		Answer = Integer.max(Answer, cnt);
		
		int nRow, nCol;
		
		for(int i = 0; i < 4; i++) {
			nRow = row + dy[i];
			nCol = col + dx[i];
			
			if(nRow < 0 || nCol < 0 || nRow >= R || nCol >= C || visit[map[nRow][nCol] - 'A']) {
				continue;
			}
			
			visit[map[nRow][nCol] - 'A'] = true;
			dfs(nRow, nCol, cnt + 1);
			visit[map[nRow][nCol] - 'A'] = false;
			
		}
	}
}
