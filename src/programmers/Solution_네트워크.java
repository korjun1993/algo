package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(computers, visit, i);
                answer++;
            }
        }
        return answer;
    }

    public void bfs(int[][] computers, boolean[] visit, int number) {
        Queue<Integer> que = new LinkedList<>();
        visit[number] = true;
        que.add(number);
        while (!que.isEmpty()) {
            int current = que.poll();
            for (int i = 0; i < computers.length; i++) {
                if (computers[current][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
