package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main7576_토마토 {
    static int M, N;
    static int[][] map;
    static int[][] dist;
    static List<Integer> start;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bfs(start));
        System.out.println(sb);
    }

    private static int bfs(List<Integer> start) {
        int answer = 0;
        Queue<Integer> que = new LinkedList();
        Iterator it = start.iterator();
        while (it.hasNext()) {
            int x = (int) it.next();
            int y = (int) it.next();
            que.offer(x);
            que.offer(y);
            dist[x][y] = 0;
        }
        /**
         * 시간초과발생
         */
//        for (int i = 0; i < start.size() - 1; i += 2) {
//            int x = start.get(i);
//            int y = start.get(i + 1);
//            que.offer(x);
//            que.offer(y);
//            dist[x][y] = 0;
//        }

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (dist[nx][ny] >= 0) {
                    continue;
                }
                if (map[nx][ny] != 0) {
                    continue;
                }
                que.offer(nx);
                que.offer(ny);
                dist[nx][ny] = dist[x][y] + 1;
                answer = Math.max(answer, dist[nx][ny]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && dist[i][j] < 0) {
                    return -1;
                }
            }
        }
        return answer;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            start = new LinkedList<>();
            map = new int[N][M];
            dist = new int[N][M];

            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        start.add(i);
                        start.add(j);
                    }
                }
            }
        } catch (Exception e) {

        }
    }
}
