package codetree.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프탐색 {
	public static int N, M;
	public static int answer;
	public static List<Integer>[] graph;
	public static boolean[] visit;

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
	}

	// vertex: 최근에 방문한 위치
	// vertex: 최근에 방문한 위치
	public static void dfs(int vertex) {
		for (int v : graph[vertex]) {
			if (!visit[v]) {
				visit[v] = true;
				answer++;
				dfs(v);
			}
		}
	}
}
