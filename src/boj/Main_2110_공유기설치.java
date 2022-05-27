package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2110_공유기설치 {
    static int N, C, min, max, answer;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        binary_search();
        System.out.println(answer);
    }

    // 1 ~ (A[0] - A[N-1]) 구간의 배열에 대해서 이진탐색을 진행하는 함수
    private static void binary_search() {
        int L = 1;
        int R = A[N - 1] - A[0];
        while (L <= R) {
            int mid = (L + R) / 2;
            if (cal(mid)) { // 최소 거리를 mid 만큼 유지하면서 c개를 둘 수 있는가?
                L = mid + 1;
                answer = mid;
            } else {
                R = mid - 1; // 둘 수 없다면 최소 간격을 줄여보자
            }
        }
    }

    // 두 공유기 사이의 최소 간격을 n으로 했을 때, 총 c개를 설치할 수 있는지 여부를 알려주는 함수
    private static boolean cal(int n) {
        int pre = 0; // 전에 공유기를 설치한 위치
        int cnt = 1; // 설치한 공유기 개수
        for (int i = 1; i < N; i++) {
            if (A[i] - A[pre] >= n) {
                pre = i;
                cnt++;
            }
            if (cnt >= C) return true;
        }
        return false;
    }
}