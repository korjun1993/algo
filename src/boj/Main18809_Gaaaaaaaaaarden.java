package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main18809_Gaaaaaaaaaarden {
    static int n, m, g, r;
    static int answer;
    static int[][] map;
    static int[][] selected;
    static List<Node> cand;
    static final int R = 1;
    static final int G = 2;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x, c, t; // 배양액의 행, 배양액의 열, 배양액의 색깔, 도착한시간

        public Node(int y, int x, int c, int t) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.t = t;
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(answer);
    }

    private static void pro() {
        solve(0, 0, -1);
    }

    /**
     * /**
     * 배양액을 뿌릴 장소를 고르는 함수
     *
     * @param red   현재까지 고른 빨간색 배양액의 수
     * @param green 현재까지 고른 초록색 배양액의 수
     * @param pre   이전에 고른 배양액의 인덱스
     */
    private static void solve(int red, int green, int pre) {
        // 주어진 배양액보다 많이 고르는 것은 불가능
        if (red > r || green > g) {
            return;
        }

        // 주어진 배양액만큼 모두 골랐을 경우
        if (red == r && green == g) {
            answer = Math.max(answer, simul());
            return;
        }

        for(int i = 0; i < cand.size(); i++) {
            if (pre >= i) {
                continue;
            }
            Node n = cand.get(i);
            if (map[n.y][n.x] == 2 && selected[n.y][n.x] == 0) {
                // i,j 위치를 빨간색 배양액 뿌릴 곳으로 정하기
                selected[n.y][n.x] = R;
                solve(red + 1, green, i);
                selected[n.y][n.x] = 0;

                // i,j 위치를 초록색 배양액 뿌릴 곳으로 정하기
                selected[n.y][n.x] = G;
                solve(red, green + 1, i);
                selected[n.y][n.x] = 0;
            }
        }
    }

    private static int simul() {
        int result = 0;
        Queue<Node> q = new LinkedList();
        Node[][] vis = new Node[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = new Node(0, 0, 0, -1);
                if (selected[i][j] == R || selected[i][j] == G) {
                    q.offer(new Node(i, j, selected[i][j], 0));
                    vis[i][j].c = selected[i][j];
                    vis[i][j].t = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (vis[cur.y][cur.x].c == R + G) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int nt = cur.t + 1;
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) { // bound check
                    continue;
                }
                if (vis[ny][nx].c == R + G || map[ny][nx] == 0) { // logic check
                    continue;
                }
                if (vis[ny][nx].c == 0 || (vis[ny][nx].c != cur.c && vis[ny][nx].t == nt)) { // logic check
                    vis[ny][nx].c += cur.c;
                    vis[ny][nx].t = nt;
                    if (vis[ny][nx].c == R + G) {
                        result++;
                    } else {
                        q.offer(new Node(ny, nx, cur.c, nt));
                    }
                }
            }
        }
        return result;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str[] = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            g = Integer.parseInt(str[2]);
            r = Integer.parseInt(str[3]);
            map = new int[n][];
            selected = new int[n][m];
            cand = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2) {
                        cand.add(new Node(i, j, 0, 0));
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}