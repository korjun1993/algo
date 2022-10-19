package boj;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2667_단지번호붙이기 {
    static int n;
    static int[][] map;
    static boolean[][] vis;
    static List<Integer> ans;
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] || map[i][j] == 0) continue;
                int house = bfs(new Node(i, j));
                ans.add(house);
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        Iterator it = ans.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static int bfs(Node start) {
        int house = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        vis[start.row][start.col] = true;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            house++;
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + dy[i];
                int nextCol = cur.col + dx[i];
                if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n || vis[nextRow][nextCol] || map[nextRow][nextCol] == 0) {
                    continue;
                }
                vis[nextRow][nextCol] = true;
                que.add(new Node(nextRow, nextCol));
            }
        }
        return house;
    }

    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            vis = new boolean[n][n];
            ans = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = Character.getNumericValue(input.charAt(j));
                }
            }
        } catch (Exception e) {
        }
    }

    private static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
