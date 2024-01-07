package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_하노이탑 {
	public static void main(String[] args) {
		int[][] answer = solution(3);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
	}
	public static int[][] solution(int n) {
		List<Integer[]> arr = new ArrayList<>();
		hanoi(arr, n, 1, 2, 3);
		int[][] answer = new int[arr.size()][2];
		for (int i = 0; i < arr.size(); i++) {
			Integer[] e = arr.get(i);
			answer[i][0] = e[0];
			answer[i][1] = e[1];
		}
		return answer;
	}

	// size 개수의 하노이 탑을 from에서 temp를 거쳐 to로 이동시키는 함수
	public static void hanoi(List<Integer[]> arr, int size, int from, int temp, int to) {
		if (size == 1) {
			arr.add(new Integer[] {from, to});
			return;
		}
		hanoi(arr, size - 1, from, to, temp);
		arr.add(new Integer[] {from, to});
		hanoi(arr, size - 1, temp, from, to);
	}
}
