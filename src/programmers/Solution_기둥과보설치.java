package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 테스트 1 〉	통과 (0.07ms, 74.8MB)
 * 테스트 2 〉	통과 (0.11ms, 74.4MB)
 * 테스트 3 〉	통과 (0.07ms, 71.9MB)
 * 테스트 4 〉	통과 (0.06ms, 77.1MB)
 * 테스트 5 〉	통과 (0.06ms, 76.4MB)
 * 테스트 6 〉	통과 (0.26ms, 76.7MB)
 * 테스트 7 〉	통과 (0.05ms, 76.5MB)
 * 테스트 8 〉	통과 (0.04ms, 77.4MB)
 * 테스트 9 〉	통과 (0.06ms, 76.3MB)
 * 테스트 10 〉	통과 (4.56ms, 82.5MB)
 * 테스트 11 〉	통과 (6.51ms, 89.6MB)
 * 테스트 12 〉	통과 (11.37ms, 83MB)
 * 테스트 13 〉	통과 (16.29ms, 88.7MB)
 * 테스트 14 〉	통과 (4.31ms, 75.8MB)
 * 테스트 15 〉	통과 (6.64ms, 90.8MB)
 * 테스트 16 〉	통과 (11.83ms, 76.1MB)
 * 테스트 17 〉	통과 (15.59ms, 87.6MB)
 * 테스트 18 〉	통과 (25.37ms, 81.7MB)
 * 테스트 19 〉	통과 (27.70ms, 86.2MB)
 * 테스트 20 〉	통과 (30.44ms, 82.4MB)
 * 테스트 21 〉	통과 (35.01ms, 81.7MB)
 * 테스트 22 〉	통과 (33.32ms, 89.9MB)
 * 테스트 23 〉	통과 (33.66ms, 85.1MB)
 */
public class Solution_기둥과보설치 {
    static final int PILLAR = 0;
    static final int BEAM = 1;
    static int SIZE;

    public static void main(String[] args) {
        int n = 5; // 벽면크기
        int[][] build_frame = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        int[][] answer = solution(n, build_frame);
    }

    private static int[][] solution(int n, int[][] build_frame) {
        boolean[][][] map = new boolean[n + 1][n + 1][2];
        int count = 0;
        SIZE = n;

        for (int i = 0; i < build_frame.length; i++) {
            count += process(map, build_frame[i]);
        }

        // 반환 배열 생성
        int[][] answer = new int[count][3];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= 1; k++) {
                    if (map[i][j][k]) {
                        answer[idx][0] = i;
                        answer[idx][1] = j;
                        answer[idx][2] = k;
                        idx++;
                    }
                }
            }
        }

        return answer;
    }

    private static int process(boolean[][][] map, int[] info) {
        int x = info[0];
        int y = info[1];
        int a = info[2];
        int b = info[3];

        if (b == 0 && isAvailableRemove(map, x, y, a)) {
            map[x][y][a] = false;
            return -1;
        } else if (b == 1 && isAvailableInstall(map, x, y, a)) {
            map[x][y][a] = true;
            return 1;
        }

        // 동작이 무시된 경우
        return 0;
    }

    private static boolean isInBoundary(int x, int y) {
        return (x >= 0 && x <= SIZE && y >= 0 && y <= SIZE);
    }

    private static boolean isAvailableInstall(boolean[][][] map, int x, int y, int a) {
        if (a == PILLAR) {
            // 바닥 위일 때
            if (y == 0) return true;
            // 아래에 기둥이 받치고 있을 때
            if (isInBoundary(x, y - 1) && map[x][y - 1][PILLAR]) return true;
            // 보의 오른쪽끝이 기둥을 받치고 있을 때
            if (isInBoundary(x - 1, y) && map[x - 1][y][BEAM]) return true;
            // 보의 왼쪽끝이 기둥을 받치고 있을 때
            if (map[x][y][BEAM]) return true;
        } else if (a == BEAM) {
            // 왼쪽을 기둥이 받치고 있을 때
            if (isInBoundary(x, y - 1) && map[x][y - 1][PILLAR]) return true;
            // 오른쪽을 기둥이 받치고 있을 때
            if (isInBoundary(x + 1, y - 1) && map[x + 1][y - 1][PILLAR]) return true;
            // 양쪽 끝에 보가 있을 때
            if (isInBoundary(x - 1, y) && map[x - 1][y][BEAM] && isInBoundary(x + 1, y) && map[x + 1][y][BEAM])
                return true;
        }

        // 그외
        return false;
    }

    private static boolean isAvailableRemove(boolean[][][] map, int x, int y, int a) {
        map[x][y][a] = false;
        for (int i = 0; i <= SIZE; i++) {
            for (int j = 0; j <= SIZE; j++) {
                for (int k = PILLAR; k <= BEAM; k++) {
                    if (map[i][j][k] && !isAvailableInstall(map, i, j, k)) {
                        map[x][y][a] = true;
                        return false;
                    }
                }
            }
        }
        map[x][y][a] = true;
        return true;
    }
}