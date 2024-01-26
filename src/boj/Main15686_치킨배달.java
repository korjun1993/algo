package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main15686_치킨배달 {

	static int N, M, Min;
	static String[] s;
	static List<Pos> c; // 치킨집
	static List<Pos> h; // 집
	static boolean[] check; // 방문체크

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num;

		s = br.readLine().split(" ");

		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		c = new ArrayList<>();
		h = new ArrayList<>();

		Min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				num = Integer.parseInt(s[j]);

				if (num == 1) {
					h.add(new Pos(i, j));
				} else if (num == 2) {
					c.add(new Pos(i, j));
				}
			}
		}

		check = new boolean[c.size()];

		comb(0, M);

		System.out.println(Min);
	}

	private static void comb(int idx, int cnt) { // cnt : 고를 수 있는 개수, idx : 현재 뽑을지 말지 고려하고 있는 치킨집
		if (idx == c.size() || cnt == 0) {
			if (cnt < M) {
				Min = Math.min(Min, getSum());
			}
			return;
		}

		// 선택
		check[idx] = true;
		comb(idx + 1, cnt - 1);

		// 선택 안함
		check[idx] = false;
		comb(idx + 1, cnt);
	}

	private static int getSum() { // 각 집마다 짧은 치킨 집 거리의 총합 구하기
		int sum = 0;
		int min;
		int temp;
		Pos chicken;

		for (Pos home : h) {
			min = Integer.MAX_VALUE;

			for (int i = 0; i < c.size(); i++) {
				if (!check[i])
					continue; // 선택하지 않은 치킨집은 넘긴다

				chicken = c.get(i); // 선택한 치킨집
				temp = Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y);
				min = Math.min(temp, min);
			}

			sum += min;
		}

		return sum;
	}

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
