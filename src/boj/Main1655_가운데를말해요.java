package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main1655_가운데를말해요 {
    static int N;
    static int[] numbers;

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }

    private static void pro() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            if (maxheap.size() == minheap.size()) {
                maxheap.offer(numbers[i]);
            } else {
                minheap.offer(numbers[i]);
            }

            if (!maxheap.isEmpty() && !minheap.isEmpty() &&
                    minheap.peek() < maxheap.peek()) {
                int temp = maxheap.poll();
                maxheap.offer(minheap.poll());
                minheap.offer(temp);
            }
            sb.append(maxheap.peek()).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
    }
}
