import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_15685 {
	public static int N, Answer;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };
	public static boolean[][] map;
	public static String[] s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Curve> list = new ArrayList<Curve>();
		int x, y, d, dd, g, size;
		Curve next;

		N = Integer.parseInt(br.readLine());

		map = new boolean[101][101];

		for (int i = 0; i < N; i++) {
			s = br.readLine().trim().split(" ");
			x = Integer.parseInt(s[0]); // 0~100 x좌표
			y = Integer.parseInt(s[1]); // 0~100 y좌표
			d = Integer.parseInt(s[2]); // 0~3 방향
			g = Integer.parseInt(s[3]); // 0~10 세대

			// 0세대 직선
			map[y][x] = true;
			y += dy[d];
			x += dx[d];
			map[y][x] = true;
			list.add(new Curve(x, y, d));

			// 세대(g) 만큼 반복
			for (int j = 0; j < g; j++) {

				size = list.size();

				// 최근에 추가한 선분부터 방향 전환
				for (int k = size - 1; k >= 0; k--) {
					next = list.get(k);

					// 방향 전환
					dd = (next.d + 1) % 4;

					// 선분 긋기
					x += dx[dd];
					y += dy[dd];
					map[y][x] = true;

					// 리스트에 추가
					list.add(new Curve(x, y, dd));
				}
			}
			list.clear();
		}

		// 사각형 수
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					Answer++;
				}
			}
		}
		System.out.println(Answer);
	} // main

	static class Curve {
		int x;
		int y;
		int d;

		public Curve(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
