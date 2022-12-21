package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1074_Z {
    static int N;
    static int r, c;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        solve(0, 0, 0, N);
    }

    private static void solve(int row, int col, int number, int size) {
        if (size == 0) {
            if (row == r && col == c) {
                System.out.println(number);
            }
            return;
        }

        size--;
        int width = (int) Math.pow(2, size); // 4사분면으로 나뉘어질때, 한 구역의 폭
        int count = width * width; // 4사분면으로 나뉘어질때, 한 구역의 요소 수
        int nextCol = col + width; // 2,4 사분면의 x좌표
        int nextRow = row + width; // 3,4 사분면의 y좌표

        if (r < nextRow && c < nextCol) { // 1사분면에 위치할 경우
            solve(row, col, number, size);
        } else if (r < nextRow && c >= nextCol) { // 2사분면에 위치한 경우
            solve(row, nextCol, number + count, size);
        } else if (r >= nextRow && c < nextCol) { // 3사분면에 위치한 경우
            solve(nextRow, col, number + 2 * count, size);
        } else { // 4사분면에 위치한 경우
            solve(nextRow, nextCol, number + 3 * count, size);
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
    }
}
