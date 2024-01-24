package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main14719_빗물 {
	static int H, W, ans;
	static int[] a;

	public static void main(String[] args) throws Exception {
		input();
		process();
	}

	private static void process() {
		for (int i = 1; i < W - 1; i++) {
			// 현재 위치의 왼쪽,오른쪽으로 탐색을 한다.
			// 양 위치에 현재 값보다 큰게 존재한다면
			// 둘 중에 (작은 값 - 현재 값)을 정답에 더해준다.
			int L = i, R = i, v1 = a[i], v2 = a[i];
			while (--L >= 0) {
				if (a[L] > v1)
					v1 = a[L];
			}
			while (++R < W) {
				if (a[R] > v2)
					v2 = a[R];
			}
			if (v1 > a[i] && v2 > a[i]) {
				int min = Math.min(v1, v2);
				ans += min - a[i];
			}
		}
		System.out.println(ans);
	}

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		H = Integer.parseInt(str[0]);
		W = Integer.parseInt(str[1]);
		a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}
