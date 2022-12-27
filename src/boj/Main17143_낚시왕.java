package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main17143_낚시왕 {

	static int R, C; // 격자판 크기
	static int M; // 상어 수
	static int F; // 낚시왕 위치
	static int Z; // 상어크기 합
	static Shark[][] map; // 격자판
	static List<Shark> sharks = new ArrayList<Shark>(); // 상어들
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;
		int r, c, s, d, z;

		input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		M = Integer.parseInt(input[2]);

		F = 0;
		map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			r = Integer.parseInt(input[0]);
			c = Integer.parseInt(input[1]);
			s = Integer.parseInt(input[2]);
			d = Integer.parseInt(input[3]);
			z = Integer.parseInt(input[4]);
			Shark shark = new Shark(r, c, s, d, z);
			sharks.add(shark);
			map[r][c] = shark;
		}

		while (F++ < C) { // 1. 낚시꾼 이동
			fish(); // 2. 상어 낚시
			move(); // 3. 상어 이동
		}
		System.out.println(Z);
	}

	private static void fish() {
		for (int i = 1; i <= R; i++) {
			if (map[i][F] != null) {
				Shark shark = map[i][F];
				Z += shark.z;
				sharks.remove(shark);
				map[i][F] = null;
				break;
			}
		}
	}

	private static void move() {
		int nr, nc, nd;

		for (Shark shark : sharks) {
			for (int s = 0; s < shark.s; s++) {
				nd = shark.d;
				nr = shark.r + dy[shark.d];
				nc = shark.c + dx[shark.d];
				
				if (nc <= 0 || nc > C || nr <= 0 || nr > R) {
					if (shark.d == 1) {
						nd = 2;
					} else if (shark.d == 2) {
						nd = 1;
					} else if (shark.d == 3) {
						nd = 4;
					} else if (shark.d == 4) {
						nd = 3;
					}
				}
				shark.d = nd;
				shark.r += dy[shark.d];
				shark.c += dx[shark.d];
			}
		}
		
		map = new Shark[R + 1][C + 1];
		List<Shark> remove = new ArrayList<>();
		
		sharks.forEach(shark -> {
			Shark other = map[shark.r][shark.c];
			if(other == null) {
				map[shark.r][shark.c] = shark;
			}
			else if(other.z > shark.z){
				map[shark.r][shark.c] = other;
				remove.add(shark);
			}
			else {
				map[shark.r][shark.c] = shark;
				remove.add(other);
			}
		});
		sharks.removeAll(remove);
	}

	static class Shark {
		int r, c, s, d, z;

		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
