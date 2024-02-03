package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5582_공통부분문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] ch1 = br.readLine().toCharArray();
		char[] ch2 = br.readLine().toCharArray();
		int size1 = ch1.length;
		int size2 = ch2.length;
		int dp[][] = new int[size1 + 1][size2 + 1];
		int max = Integer.MIN_VALUE;
		int temp;
		
		for (int i = 0; i < ch1.length; i++) {
			for (int j = 0; j < ch2.length; j++) {
				if (ch1[i] == ch2[j]) {
					if(i == 0 || j == 0) dp[i][j] = 1;
					else dp[i][j] = 1 + dp[i - 1][j - 1];
				}
			}
			
			if(max < (temp = Arrays.stream(dp[i]).max().getAsInt())) {
				max = temp;
			}
		}
		
		System.out.println(max);
	}
}
