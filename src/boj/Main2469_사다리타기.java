package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2469_사다리타기 {
    static int k, n;
    static int secret;
    static int count;
    static int[] want;
    static char[][] map;

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int ch = 0; ch < k; ch++) {
            int downRow = 0, downCol = ch;
            int upRow = n - 1, upCol = want[ch];
            while (downRow < secret) {
                downCol = move(downRow, downCol);
                downRow++;
            }
            while (upRow > secret) {
                upCol = move(upRow, upCol);
                upRow--;
            }
            setValue(downCol, upCol);
        }
        if (count != k) {
            System.out.println("x".repeat(k - 1));
            return;
        }
        for (int i = 0; i < k - 1; i++) {
            if (map[secret][i] == '?') map[secret][i] = '*';
            System.out.print(map[secret][i]);
        }
    }

    private static void setValue(int downCol, int endCol) {
        if (Math.abs(downCol - endCol) == 1) {
            int target = Math.min(downCol, endCol); // 가로 막대를 놓을 위치의 열 좌표
            if (map[secret][target] != '*') {
                map[secret][target] = '-';
                count++;
            }
        } else if (downCol == endCol) {
            int target = downCol;
            char right = target < k - 1 ? map[secret][target] : '*';
            char left = target > 0 ? map[secret][target - 1] : '*';
            if (left != '-' && right != '-') {
                if (target < k - 1) map[secret][target] = '*';
                if (target > 0) map[secret][target - 1] = '*';
                count++;
            }
        }
    }

    private static int move(int row, int col) {
        if (col < k - 1 && map[row][col] == '-') col++;
        else if (col > 0 && map[row][col - 1] == '-') col--;
        return col;
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            want = new int[k];
            map = new char[n][];
            String str = br.readLine();
            for (int i = 0; i < k; i++) {
                int order = str.charAt(i) - 'A'; // A~Z 중 몇 번째 알파벳인가?
                want[order] = i; // order번째 알파벳은 사다리 결과 i번째에 위치하기를 원한다.
            }
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                if (map[i][0] == '?') {
                    secret = i;
                }
            }
        } catch (Exception ignored) {
        }
    }
}
