package programmers;

/*
테스트 1 〉	통과 (0.03ms, 74.7MB)
테스트 2 〉	통과 (0.02ms, 75.3MB)
테스트 3 〉	통과 (0.08ms, 78.2MB)
테스트 4 〉	통과 (0.18ms, 78MB)
테스트 5 〉	통과 (1.11ms, 70MB)
테스트 6 〉	통과 (2.63ms, 75.8MB)
테스트 7 〉	통과 (3.93ms, 78.2MB)
테스트 8 〉	통과 (6.85ms, 83.2MB)
테스트 9 〉	통과 (11.20ms, 82MB)
테스트 10 〉	통과 (8.96ms, 80MB)
 */
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
