package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_경주로건설 {
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 1}, {1, 0, 0, 0}};

        int answer = solution(board);
        System.out.println(answer);
    }

    private static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        Queue<Node> q = new LinkedList<Node>();
        int[][][] cost = new int[n][n][4];

        q.add(new Node(0, 0, 0, -1));
        board[0][0] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            // 최소 비용 갱신
            if (node.x == n - 1 && node.y == n - 1)
                answer = Math.min(answer, cost[node.y][node.x][node.d]);

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny >= n || nx >= n || ny < 0 || nx < 0) continue; // index 초과 X
                if (board[ny][nx] == 1) continue; // 벽면 X
                if (i + node.d == 1 || i + node.d == 5) continue; // 되돌아가는 방향 X

                // 새로운 비용 구하기
                int nc = node.c;
                if (node.d != -1 && node.d != i) nc += 600;
                else nc += 100;

                // 새로운 탐색 경로의 방향이 기존과 같고, 비용이 높으면 제외
                if (cost[ny][nx][i] != 0 && cost[ny][nx][i] < nc) continue;

                q.add(new Node(ny, nx, nc, i));

                // 기존 비용과 비교하여 memoization
                if (cost[ny][nx][i] == 0 || cost[ny][nx][i] > nc) cost[ny][nx][i] = nc;
            }
        }

        return answer;
    }

    static class Node {
        int y, x, c, d;

        public Node(int y, int x, int c, int d) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.d = d;
        }
    }
}