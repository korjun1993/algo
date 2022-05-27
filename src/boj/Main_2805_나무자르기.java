package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2805_나무자르기 {
    static int N, M, answer;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(A);
        binary_search();
        System.out.println(answer);
    }

    // 0 ~ A[N-1] 구간의 배열에 대해서 이진탐색을 진행하는 함수
    private static void binary_search() {
        int L = 0;
        int R = A[N - 1];
        while (L <= R) {
            int mid = (L + R) / 2;
            long result = cal(mid); // 가져가는 나무 길이 계산
            if (result >= M) {
                L = mid + 1; // 설정 높이를 올릴수록, 가져가는 나무의 양이 작아짐
                answer = mid;
            } else {
                R = mid - 1; // 설정 높이를 낮출수록, 가져가는 나무의 양이 많아짐
            }
        }
    }

    // 높이 설정을 n으로 했을 때, 가져갈 수 있는 나무 높이를 계산하는 함수
    private static long cal(int n) {
        long result = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] > n) result += A[i] - n;
        }
        return result;
    }
}