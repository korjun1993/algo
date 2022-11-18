package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main9489_사촌 {
    static int n, k, indexOfk;
    static int[] numbers = new int[1001];
    static int[] parent = new int[1001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> que = new PriorityQueue<>();

    public static void main(String[] args) {
        while (true) {
            input();
            if (n != 0 && k != 0) pro();
            else break;
        }
    }

    private static void pro() {
        que.offer(0);
        int child = 1;
        while (child < n) {
            int target = que.poll(); // 아직 자식이 없고 가장 작은 수를 가지는 노드
            int lastChild = addChild(target, child++); // 조건 없이 첫 번째 자식을 갖는다.
            while (child < n) {
                if (lastChild + 1 == numbers[child]) {
                    lastChild = addChild(target, child++);
                } else break;
            }
        }
        long ans = IntStream.range(0, n).filter(Main9489_사촌::isCousin).count();
        System.out.println(ans);
    }

    private static int addChild(int parentIndex, int childIndex) {
        parent[childIndex] = parentIndex;
        que.offer(childIndex);
        return numbers[childIndex];
    }

    private static boolean isCousin(int index) {
        return parent[index] > 0
                && parent[index] != parent[indexOfk]
                && parent[parent[index]] == parent[parent[indexOfk]];
    }

    private static void input() {
        try {
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            k = Integer.parseInt(str[1]);
            if (n > 0 && k > 0) {
                str = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    numbers[j] = Integer.parseInt(str[j]);
                    if (numbers[j] == k) indexOfk = j;
                }
            }
            Arrays.fill(parent, -1);
            que.clear();
        } catch (Exception ignored) {
        }
    }
}
