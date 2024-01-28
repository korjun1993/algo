package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main17825_주사위윷놀이 {
	// 이 문제는 '윷놀이 판을 어떻게 구현할 것인가' 가 핵심
	// 각 노드를 만들고 연결관계를 나타내자
	static List<Integer>[] map = new List[33]; // 윷놀이판
	static int[] score = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, 22, 24, 13,
		16, 19, 25, 26, 27, 28, 30, 35}; // 점수판
	static int[] cmd = new int[10]; // 주사위에서 나올 수 10개
	static int answer; // 정답

	public static void main(String[] args) throws Exception {

		// 윷놀이판을 그려보자
		for (int i = 0; i < 33; i++) {
			map[i] = new LinkedList<>();
		}

		map[0].add(1);
		map[1].add(2);
		map[2].add(3);
		map[3].add(4);
		map[4].add(5);
		map[5].add(6);
		map[6].add(7);
		map[7].add(8);
		map[8].add(9);
		map[9].add(10);
		map[10].add(11);
		map[11].add(12);
		map[12].add(13);
		map[13].add(14);
		map[14].add(15);
		map[15].add(16);
		map[16].add(17);
		map[17].add(18);
		map[18].add(19);
		map[19].add(20);
		map[20].add(21);
		map[5].add(24);
		map[24].add(25);
		map[25].add(26);
		map[26].add(27);
		map[10].add(22);
		map[22].add(23);
		map[23].add(27);
		map[15].add(30);
		map[30].add(29);
		map[29].add(28);
		map[28].add(27);
		map[27].add(31);
		map[31].add(32);
		map[32].add(20);

		// 입력을 받자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 모든 경우를 다 해보자
		// dfs(idx번째 주사위, idx번째 주사위를 어떤 말에게 적용할지를 갖는 배열)
		int[] arr = new int[10];
		dfs(0, arr);
		System.out.println(answer);
	}

	private static void dfs(int idx, int[] arr) {
		if (idx == 10) {
			answer = Integer.max(answer, simulate(arr));
			return;
		}

		for (int i = 0; i < 4; i++) {
			arr[idx] = i;
			dfs(idx + 1, arr);
		}
	}

	// 10번의 이동 후 집계된 점수를 리턴하자
	private static int simulate(int[] arr) {
		int sum = 0; // 점수 합계
		int[] loc = new int[4]; // 말의 현재 위치
		boolean[] visit = new boolean[4]; // 말의 도착 여부
		int cnt; // 말의 이동칸수
		int target; // 움직일 말의 번호

		for (int i = 0; i < 10; i++) {
			target = arr[i];
			cnt = cmd[i];

			if (!visit[target]) {
				// 첫 번째 이동
				if (loc[target] == 5 || loc[target] == 10 || loc[target] == 15) {
					loc[target] = map[loc[target]].get(1);
					cnt--;
				}

				// n번째 이동
				while (cnt-- > 0) {
					loc[target] = map[loc[target]].get(0);

					// 도착점에 도달했는지 검사후 체크
					if (loc[target] == 21) {
						visit[target] = true;
						break;
					}
				}

				// 이동 가능 여부 검사 후 접수 합산
				if (isAvailable(loc)) {
					sum += score[loc[target]];
				} else {
					sum = -1;
					break;
				}
			}
		}
		return sum;
	}

	// 이동 가능 여부를 검사하자
	private static boolean isAvailable(int[] loc) {
		boolean flag = true;
		boolean[] visit = new boolean[33];

		for (int i = 0; i < 4; i++) {
			if (loc[i] == 21 || loc[i] == 0)
				continue;
			if (!visit[loc[i]]) {
				visit[loc[i]] = true;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
