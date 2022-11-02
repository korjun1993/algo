package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main11000_강의실배정 {
    static int n;
    static List<Lecture> lectures = new ArrayList<>();

    public static void main(String[] args) {
        input();
        pro();
    }

    private static void pro() {
        int ans = 0;
        PriorityQueue<Lecture> pq = new PriorityQueue<Lecture>();
        lectures.sort((Lecture l1, Lecture l2) -> l1.start - l2.start);
        for (Lecture newLec : lectures) {
            while (!pq.isEmpty() && pq.peek().end <= newLec.start) {
                pq.poll();
            }
            pq.add(newLec);
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                int start = Integer.parseInt(str[0]);
                int end = Integer.parseInt(str[1]);
                lectures.add(new Lecture(start, end));
            }
        } catch (Exception e) {
        }
    }

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.end - o.end;
        }
    }
}
