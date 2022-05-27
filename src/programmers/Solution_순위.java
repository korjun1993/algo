package programmers;

public class Solution_순위 {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int answer = solution(n, results);
        System.out.println(answer);
    }

    private static int solution(int n, int[][] results) {
        int answer = 0;
        int adj[][] = new int[n + 1][n + 1];
        for(int i = 0; i < results.length; i++) {
            int playerA = results[i][0];
            int playerB = results[i][1];
            adj[playerA][playerB] = 1;
        }

        // A->B, B->C = A->C
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] == 1 || adj[j][i] == 1) count++;
            }
            if (count == (n - 1)) answer++;
        }
        return answer;
    }
}

// 선수의 수 n = 1 이상 100 이하
// 경기 결과 = 1 이상 4500 이하
// 시간복잡도 = N^3
