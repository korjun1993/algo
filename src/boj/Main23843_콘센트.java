package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main23843_콘센트 {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}
	
	public static void pro() {
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(arr);
		
		// 초기 m개 작업 수행
		for (int i = 0; i < m; i++) {
            if (arr.length - 1 - i < 0) break;
			pq.add(arr[arr.length - 1 - i]);
		}
		
		int order = arr.length - 1 - m;
		while(!pq.isEmpty()) {
			int currentTime = pq.poll();
			ans = currentTime;
			if (order < 0) continue;
			pq.add(currentTime + arr[order]);
      order--;
		}
		System.out.println(ans);
	}
	
	public static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}
