package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_아이템줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        // 직사각형 내부를 1로 채운다.
        int[][] map = new int[102][102];
        for (int[] coordinate : rectangle) {
            for (int y = coordinate[1] * 2 + 1; y < coordinate[3] * 2; y++) {
                for (int x = coordinate[0] * 2 + 1; x < coordinate[2] * 2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        // 직사각형 외부 선분을 그려준다.
        for (int[] coordinate : rectangle) {
            for (int y = coordinate[1] * 2; y <= coordinate[3] * 2; y++) {
                for (int x = coordinate[0] * 2; x <= coordinate[2] * 2; x++) {
                    if (map[y][x] == 1) continue;
                    map[y][x] = 2;
                }
            }
        }

        // bfs를 시작한다.
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> que = new LinkedList<>();
        boolean[][] visit = new boolean[102][102];
        int[][] dist = new int[102][102];

        // 시작점 초기화
        visit[2 * characterY][2 * characterX] = true;
        que.offer(2 * characterY);
        que.offer(2 * characterX);

        while (!que.isEmpty()) {
            int y = que.poll();
            int x = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dir[i][0];
                int nx = x + dir[i][1];
                if (ny < 0 || ny >= map.length || nx < 0 || nx >= map.length) continue;
                if (visit[ny][nx]) continue;
                if (map[ny][nx] != 2) continue;
                visit[ny][nx] = true;
                dist[ny][nx] = dist[y][x] + 1;
                que.add(ny);
                que.add(nx);
            }
        }

        return dist[2 * itemY][2 * itemX] / 2;
    }
}
