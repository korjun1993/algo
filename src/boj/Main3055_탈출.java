package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main3055_탈출 {
    static int R, C;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] dist;
    static int[] start;
    static boolean[][][] vis;
    static List<Integer> water;
    static char map[][];

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        Queue<Integer> que = new LinkedList<>();

        // 고슴도치 체크 및 큐 삽입
        que.add(start[0]);
        que.add(start[1]);
        que.add(0); // 0은 고슴도치
        dist[start[0]][start[1]] = 0;
        vis[start[0]][start[1]][0] = true;

        // 물 체크 및 큐 삽입
        for (int i = 0; i < water.size(); i += 2) {
            int x = water.get(i);
            int y = water.get(i + 1);
            que.add(x);
            que.add(y);
            que.add(1);
            vis[x][y][1] = true;
        }

        // bfs 탐색 시작
        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            int z = que.poll();
            if (z == 0) {
                if (map[x][y] == '*') continue; // 고슴도치가 있는 곳에 물이 도착한 케이스 제거
                if (map[x][y] == 'D') { // 고슴도치가 비버의 굴에 도착
                    System.out.println(dist[x][y]);
                    return;
                }
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (map[nx][ny] == 'X') {
                    continue;
                }
                if (vis[nx][ny][z]) {
                    continue;
                }
                if (z == 1) { // water가 인접한 정점으로 이동
                    if (map[nx][ny] == 'D') continue; // 물은 굴로 이동할 수 없다.
                    map[nx][ny] = '*';
                } else { // 고슴도치가 이동
                    if (map[nx][ny] == '*') continue; // 고슴도치는 물로 이동할 수 없다.
                    dist[nx][ny] = dist[x][y] + 1;
                }
                vis[nx][ny][z] = true;
                que.add(nx);
                que.add(ny);
                que.add(z);
            }
        }

        // 비버의 굴로 도착하지 못한 경우
        System.out.println("KAKTUS");
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str[] = br.readLine().split(" ");
            R = Integer.parseInt(str[0]);
            C = Integer.parseInt(str[1]);
            map = new char[R][C];
            dist = new int[R][C];
            vis = new boolean[R][C][2];
            start = new int[2];
            water = new LinkedList<>();
            for (int i = 0; i < R; i++) {
                String input = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == 'S') {
                        map[i][j] = '.';
                        start[0] = i;
                        start[1] = j;
                    } else if (map[i][j] == '*') {
                        water.add(i);
                        water.add(j);
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}
