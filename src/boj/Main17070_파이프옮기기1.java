import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main17070_파이프옮기기1 {

	static int N; // 집의 크기 :: 3 ~ 16
	static int Answer; // 답
	static int[][] map; // 집의 상태 :: 빈칸0 , 벽1
	static int[][][] dp; // i, j에 도착할 수 있는 방법의 수 :: 0-가로, 1-세로, 2-대각
	static String[] s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3];

		for (int i = 1; i <= N; i++) {
			s = br.readLine().split(" ");

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(s[j - 1]);
			}
		}

		// 초기조건
		// 가장 처음 (1,1) (1,2) 가로
		dp[1][2][0] = 1;
		dp[1][2][1] = 0;
		dp[1][2][2] = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {

				if (i == 1 && j == 2)
					continue;

				if (map[i][j] != 1) { // 벽이면 제외
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]; // 세로
					if (map[i][j - 1] != 1 && map[i - 1][j] != 1) // 대각선의 특성 고려
						dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]; // 대각
				}
			}
		}

		Answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];

		System.out.println(Answer);
	}
}
