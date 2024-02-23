package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1347_미로만들기 {

	public static int N;
	public static char[] A;
	public static final int[] dx = { 0, -1, 0, 1 };
	public static final int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[][] map = new char[100][100];
		int startX = 50;
		int startY = 50;
		int state = 0;

		for (int i = 0; i < 100; i++) {
			Arrays.fill(map[i], '#');
		}

		N = Integer.parseInt(br.readLine());

		A = br.readLine().toCharArray();

		map[startY][startX] = '.';

		for (int i = 0; i < N; i++) {
			if (A[i] == 'F') {
				startX += dx[state];
				startY += dy[state];
				map[startY][startX] = '.';
			}

			else if (A[i] == 'R') {
				state = (state + 1) % 4;
			}

			else if(A[i] == 'L'){
				if (state == 0) {
					state = 3;
				} else {
					state = state - 1;
				}
			}
		}

		// 행 검사
		boolean flag1, flag2;
		for (int i = 0; i < 100; i++) {
			flag1 = true;
			flag2 = true;
			
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == '.') {
					flag1 = false;
				}
				
				if(map[j][i] == '.') {
					flag2 = false;
				}
			}
			
			if(flag1) {
				Arrays.fill(map[i], '0');
			}
			
			if(flag2) {
				for(int j = 0; j < 100; j++) {
					map[j][i] = '0';
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == '0') continue;
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}
