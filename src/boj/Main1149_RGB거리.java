import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n; // 집 수
		int[][] dp; // dp표
		
		// dp 크기 설정
		String[] s;
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][3];
		
		// 입력 및 dynamic programming
		for(int i = 1; i <= n; i++) {
			s = br.readLine().split(" ");	
			dp[i][0] = Integer.parseInt(s[0]) + Integer.min(dp[i - 1][1], dp[i - 1][2]); // 빨강 선택
			dp[i][1] = Integer.parseInt(s[1]) + Integer.min(dp[i - 1][0], dp[i - 1][2]); // 초록 선택
			dp[i][2] = Integer.parseInt(s[2]) + Integer.min(dp[i - 1][0], dp[i - 1][1]); // 파랑 선택
		} 
		
		// 답 출력
		System.out.println(Arrays.stream(dp[n]).min().getAsInt());
	}
}
