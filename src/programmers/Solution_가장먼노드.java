package programmers;

import java.util.LinkedList;
import java.util.Queue;

/*
테스트 1 〉	통과 (0.36ms, 74.6MB)
테스트 2 〉	통과 (0.41ms, 76.3MB)
테스트 3 〉	통과 (0.56ms, 72.8MB)
테스트 4 〉	통과 (1.09ms, 73.9MB)
테스트 5 〉	통과 (2.36ms, 80.5MB)
테스트 6 〉	통과 (4.44ms, 79.9MB)
테스트 7 〉	통과 (26.64ms, 93.1MB)
테스트 8 〉	통과 (33.30ms, 104MB)
테스트 9 〉	통과 (75.43ms, 120MB)
 */

public class Solution_가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int edge[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int answer = solution(n, edge);
        System.out.println(answer);
    }

    private static int solution(int n, int[][] edge) {
        int answer = 0;
        int max_dis = 0;
        LinkedList<Integer> adj[] = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new LinkedList();
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            adj[x].add(y);
            adj[y].add(x);
        }
        // 그래프 탐색
        boolean[] visit = new boolean[n + 1];
        Queue<Pair> que = new LinkedList<Pair>();
        visit[1] = true;
        que.add(new Pair(1, 0));
        while (!que.isEmpty()) {
            Pair p = que.poll();
            for (int i = 0; i < adj[p.v].size(); i++) {
                int nv = adj[p.v].get(i);
                if (visit[nv]) continue;
                visit[nv] = true;
                que.add(new Pair(nv, p.dis + 1));
                if (max_dis < p.dis + 1) {
                    max_dis = p.dis + 1;
                    answer = 1;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }


    static class Pair {
        int v;
        int dis;

        public Pair(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }
}

// 노드의 개수 n : 2 이상 20,000 이하
// 양방향 그래프
// 간선 : 1 이상 50,000 이하
// 시간복잡도 : O(E)
// 공간복잡도 : O(V^2)
// 정답최대치 : 20,000