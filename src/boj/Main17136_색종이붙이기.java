package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main17136_색종이붙이기 {

	static int N; // 맵의 크기
	static int[][] map; // 맵
	static String[] s;
	static int[] visit = {5, 5, 5, 5, 5};
	static int Answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			s = br.readLine().split(" ");

			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		// dfs 시작
		dfs(0, map, visit);
		
		// 정답 출력
		if(Answer == Integer.MAX_VALUE) {
			Answer = -1;
		}
		System.out.println(Answer);
	}

	private static void dfs(int cnt, int[][] arr, int[] visit) {
		
		// 0. 백트랙킹
		if(cnt >= Answer) {
			return;
		}
		
		int row = 0;
		int col = 0;
		boolean find = false;
		boolean fittable = true;

		// 1. 색종이를 붙여야할 곳을 찾는다
		FIND: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (arr[i][j] == 1) {
					row = i;
					col = j;
					find = true;
					break FIND;
				}
			}
		}
		
		// 2. 붙일 곳이 없으면 종료한다.
		if(!find) {
			Answer = Integer.min(Answer, cnt);
		}

		// 3. 붙일 곳이 있으면 5 종류 색종이를 붙인다.
		else {
			for (int s = 1; s <= 5; s++) {
				
				// 4. 해당 사이즈의 색종이 갯수를 검사한다.
				if(visit[s - 1] == 0) {
					continue;
				}
				
				// 5. 색종이가 충분하다면, 붙일 수 있는 사이즈인가를 검사한다.
				FIND_SIZE : for (int r = 0; r < s; r++) {
					for (int c = 0; c < s; c++) {
						if(row + r >= 10 || col + c >= 10 || arr[row + r][col + c] == 0) {
							fittable = false;
							break FIND_SIZE;
						}
					}
				}
			
				// 6. 붙일 수 있다면 종이를 붙인 후 다시 호출한다.
				if(fittable) {
					int[][] temp = new int[10][10];
					int[] visit2 = new int[5];
					
					for(int i = 0; i < 10; i++) {
						System.arraycopy(arr[i], 0, temp[i], 0, 10);
					}
					
					System.arraycopy(visit, 0, visit2, 0, 5);
					
					for (int r = 0; r < s; r++) {
						for (int c = 0; c < s; c++) {
							temp[row + r][col + c] = 0;							
						}
					}
					
					visit2[s - 1]--;
					
					dfs(cnt + 1, temp, visit2);
				}
				
				// 7. 붙일 수 없다면 종료한다.
				else {
					return;
				}
			}
		}
	}
}
