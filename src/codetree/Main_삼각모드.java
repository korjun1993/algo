package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_삼각모드 {
    static class Edge {
        int x, y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N; // N: 사용자의 수
    static int M; // M: 친구관계의 수
    static int T; // T: 트라이앵글 수
    static LinkedList<Edge> edges; // edges: 친구관계를 순차적으로 담아놓는 리스트
    static LinkedList<Integer>[] adj; // adj: 친구관계를 그래프로 표현한 인접리스트

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        for (Edge e : edges) {
            int[] common = new int[N + 1];
            for (Integer k : adj[e.x]) { // x에서 도달 가능한 곳 모두 +1
                common[k]++;
            }
            for (Integer k : adj[e.y]) { // y에서 도달 가능한 곳 모두 +1
                common[k]++;
            }

            // 두 개의 점에서 공통으로 도달 가능한 곳 개수 세기
            for (int i = 1; i <= N; i++) {
                if (common[i] >= 2) {
                    T++;
                }
            }
        }

        // 모든 직선에 대해 탐색 종료후 3으로 나누기
        // 삼각형은 총 3개의 직선으로 이루어져있으므로, 한 개의 삼각형에 대해서 T+=3 계산을 수행하였음.
        T /= 3;
        System.out.println(T >= 2 ? "YES" : "NO");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        edges = new LinkedList<>();
        adj = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            edges.add(new Edge(x, y));
            adj[x].add(y);
            adj[y].add(x);
        }
    }
}