package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main16918_봄버맨 {

    static int R, C, N; // 1 ~ 200
    static int[][] bomb; // 폭탄 상태
    static char[][] map; // 맵의 상태
    static final int[] dx = { 0, 0, -1, 1 }; // 상하좌우 변위
    static final int[] dy = { -1, 1, 0, 0 }; // 상하좌우 변위
    static String[] s;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine().split(" ");

        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        N = Integer.parseInt(s[2]);

        map = new char[R][C];
        bomb = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') { // 1. 일부 칸에 폭탄을 설치한다.
                    bomb[i][j] = 4;
                }
            }
        }

        N--; // 2. 봄버맨은 아무것도 하지 않는다.
        time();

        while (N > 0) {
            // 3. 폭탄이 설치되지 않은 칸에 폭탄을 설치한다.
            time();
            N--;
            setBomb();

            if (N == 0)
                break;


            // 4. 폭탄을 폭발시킨다.
            time();
            boom();
            N--;
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void boom() {
        int nRow, nCol;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == 1) {

                    // 해당 폭탄이 터진다.
                    bomb[i][j] = 0;
                    map[i][j] = '.';

                    // 4방향의 폭탄을 제거한다.
                    for (int k = 0; k < 4; k++) {
                        nRow = i + dy[k];
                        nCol = j + dx[k];

                        if (nRow >= 0 && nRow < R && nCol >= 0 && nCol < C && bomb[nRow][nCol] != 1) {
                            bomb[nRow][nCol] = 0;
                            map[nRow][nCol] = '.';
                        }
                    }
                }
            }
        }
    }

    private static void time() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] > 0) {
                    bomb[i][j]--;
                }
            }
        }
    }

    private static void setBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bomb[i][j] == 0) {

                    // 폭탄 시간을 추가한다.
                    bomb[i][j] = 4;

                    // 폭탄을 맵에 추가한다.
                    map[i][j] = 'O';
                }
            }
        }
    }
}



