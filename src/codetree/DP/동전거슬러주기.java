package codetree.DP;

import java.util.Scanner;

public class 동전거슬러주기 {
	public static int MAX_INT = Integer.MAX_VALUE;
	public static int N, M;
	public static int[] coins;
	public static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		coins = new int[N];
		dp = new int[M + 1]; // i원을 조합할 때 동전의 최소 갯수
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}

		// 초기화
		for (int i = 0; i <= M; i++) {
			dp[i] = MAX_INT;
		}
		dp[0] = 0;

		// dp 배열 채우기
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < N; j++) {
				if (i - coins[j] < 0) continue;
				if (dp[i - coins[j]] == MAX_INT) continue;
				dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
			}
		}

		System.out.println(dp[M] == MAX_INT ? -1 : dp[M]);
	}
}
