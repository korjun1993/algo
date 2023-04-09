package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1799_비숍 {
    static int answer;
    static int n;
    static int[][] map;
    static int[][] dir = {{1, -1}, {1, 1}};

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        solve(0, 0, 0);
        System.out.println(answer);
    }

    // (row,col)~(n-1,n-1) 구간에서 비숍이 놓일 수 있는 모든 경우의 수를 탐색하는 메소드
    private static void solve(int row, int col, int count) {
        // map의 크기를 벗어날 경우 탐색 종료
        if (row >= n) {
            answer = Math.max(answer, count);
            return;
        }

        // 비숍이 놓일 다음 위치를 계산
        int nextRow = row;
        int nextCol = 0;
        if (col + 1 < n) nextCol = col + 1;
        else nextRow++;

        // 벽이있거나, 다른 비숍에 의해 놓일 수 없는 경우,
        // map[row][col]에 비숍을 두지 않는다.
        solve(nextRow, nextCol, count);

        // 벽이 없고, 다른 비숍에 영향을 받지 않는 경우,
        // map[row][col]에 비숍을 둔다.
        if (map[row][col] == 1) {
            // 방문 위치 및 대각선 위치를 방문할 수 없도록 마킹한다.
            mark(row, col);

            // 다음 위치에서 탐색을 재시작한다.
            solve(nextRow, nextCol, count + 1);

            // 탐색을 끝냈을 때 본래 map 정보가 유지되야한다.
            // 이번 탐색을 호출한 함수의 탐색에 영향을 주면 안되기 때문이다.
            unmark(row, col);
        }
    }

    private static void mark(int row, int col) {
        // 방문한 위치의 map 값을 비숍(=2)로 변경한다.
        map[row][col] = 2;

        // 4개의 대각선 방향으로 향하며 map 값을 둘수없음(0미만의수)로 변경한다.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int nextRow = row + dir[j][0] * i;
                int nextCol = col + dir[j][1] * i;
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
                if (map[nextRow][nextCol] == 1) {
                    map[nextRow][nextCol] = -(n * row + col + 1);
                }
            }
        }
    }

    private static void unmark(int row, int col) {
        // 방문한 위치의 map 값을 1로 변경한다.
        map[row][col] = 1;

        // 4개의 대각선 방향으로 향하며 map 값을 1로 변경한다.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int nextRow = row + dir[j][0] * i;
                int nextCol = col + dir[j][1] * i;
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) continue;
                if (map[nextRow][nextCol] == -(row * n + col + 1)) {
                    map[nextRow][nextCol] = 1;
                }
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
