package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main18290_NM과K {
    static int n, m, k;
    static int answer;
    static int[][] board;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        n = Integer.parseInt(inputStr[0]);
        m = Integer.parseInt(inputStr[1]);
        k = Integer.parseInt(inputStr[2]);
        board = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            inputStr = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(inputStr[j]);
            }
        }
    }

    private static void pro() {
        answer = -1000000;
        solve(0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void solve(int preRow, int preCol, int count, int value) {
        if (count == k) {
            if (answer < value) {
                answer = value;
            }
            return;
        }

        for (int row = 0; row < n; row++) {
            for (int col = (row == preRow ? preCol : 0); col < m; col++) {
                if (visit[row][col]) continue;

                boolean find = true;
                for (int k = 0; k < 4; k++) {
                    int nextRow = row + dir[k][0];
                    int nextCol = col + dir[k][1];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= m) continue;
                    if (visit[nextRow][nextCol]) {
                        find = false;
                        break;
                    }
                }

                if (find) {
                    visit[row][col] = true;
                    solve(row, col, count + 1, value + board[row][col]);
                    visit[row][col] = false;
                }
            }
        }
    }
}
