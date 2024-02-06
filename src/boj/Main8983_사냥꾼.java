package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main8983_사냥꾼 {

	public static int T, M, N, L, answer;
	public static long[] guns;
	public static List<Animal> animals;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		guns = new long[M];
		animals = new ArrayList<Animal>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			guns[i] = Long.parseLong(st.nextToken());
		}

		long x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Long.parseLong(st.nextToken());
			y = Long.parseLong(st.nextToken());

			// y값이 사정거리보다 크면 제외
			if (L < y) {
				continue;
			}

			animals.add(new Animal(x, y));
		}

		// x좌표 기준으로 오름차순 정렬
		Arrays.sort(guns);

		for (Animal animal : animals) {
			bSearch(animal, guns);
		}

		System.out.println(answer);
		answer = 0;
	}

	private static void bSearch(Animal animal, long[] guns) {
		int start = 0;
		int end = guns.length - 1;
		int mid;
		long x, y, gun;

		while (start <= end) {
			mid = (start + end) / 2;
			gun = guns[mid];
			x = animal.x;
			y = animal.y;

			if (Math.abs(x - gun) + y <= L) {
				answer++;
				return;
			}

			else {
				if (x < gun) {
					end = mid - 1;
				}

				else {
					start = mid + 1;
				}
			}
		}
	}

	static class Animal {
		long x;
		long y;

		public Animal(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}
