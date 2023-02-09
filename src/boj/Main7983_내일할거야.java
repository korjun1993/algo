package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// n개의 과제 목록 (100만)
// 과제 i는 di일이 소요 (10억)
// ti일 안에 끝내야한다 (10억)
// 내일부터 연속으로 최대 며칠동안 놀 수 있을까?
public class Main7983_내일할거야 {
    static class Node{
        int d;
        int t;
    }
    static int n;
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        nodes.sort((o1, o2) -> o2.t - o1.t);
        int today = nodes.get(0).t;
        for (Node dt : nodes) {
            if (today > dt.t) {
                today = dt.t;
            }
            today -= dt.d;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int d = Integer.parseInt(str[0]);
            int t = Integer.parseInt(str[1]);
            Node n = new Node();
            n.d = d;
            n.t = t;
            nodes.add(n);
        }
    }
}

// 2 8 => 6,7
// 1 13 => 12
// 3 10 => 8,9,10

// 1. 끝나는 날짜 순서로 정렬
// 1 13
// 3 10
// 2 8

// 2. 오늘날짜를 기록하고, 숙제를 처리한다.
// 오늘날짜 13
// 1 13 (처리, 다음날짜:12)
// 3 10
// 2 8

// 3. 끝날때까지 반복
// 오늘날짜 12
// 1 13
// 3 10 (처리할수없음, 날짜변경:12->10, 다음날짜:7)
// 2 8

// 3. 끝날때까지 반복
// 오늘날짜 7
// 1 13
// 3 10
// 2 8 (처리, 다음날짜:5)