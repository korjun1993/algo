package programmers;

import java.util.Arrays;

public class Solution_방문길이 {
    public static int solution(String dirs) {
        int answer = 0; // 방문한적이 없는 간선의 개수
        boolean vis[][][][] = new boolean[11][11][11][11];

        // 출발점 초기화
        int x = 5, y = 5;

        // 명령어에 따라 이동 시작
        for (int i = 0; i < dirs.length(); i++) {
            int nx = x;
            int ny = y;
            if (dirs.charAt(i) == 'U') {
                nx--;
            } else if (dirs.charAt(i) == 'D') {
                nx++;
            } else if (dirs.charAt(i) == 'L') {
                ny--;
            } else {
                ny++;
            }

            // 좌표를 벗어나는 경우 무시
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) {
                continue;
            }

            // 방문한적이 있는 경우 정답--
            if (vis[nx][ny][x][y] || vis[x][y][nx][ny]) {
                answer--;
            }

            // 방문처리
            vis[nx][ny][x][y] = vis[x][y][nx][ny] = true;
            answer++;
            x = nx;
            y = ny;
        }
        return answer;
    }

    public static void main(String[] args) {
        int answer = solution("RL");
        System.out.println(answer);
    }
}
