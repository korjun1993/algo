import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main17406_배열돌리기4 {
	
	static Node[] nodes; // 회전 순서
	static int[][] A; // 배열 A
	static int N, M; // 배열 A의 크기
	static int K; // 회전 연산의 개수
	static int Answer =  Integer.MAX_VALUE; // 연산 결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열A 입력
		
		String[] ss;
		
		ss = br.readLine().split(" ");
		
		N = Integer.parseInt(ss[0]);
		M = Integer.parseInt(ss[1]);
		K = Integer.parseInt(ss[2]);
		
		A = new int[N + 1][M + 1];
		nodes = new Node[K];
		
		for(int i = 1; i <= N; i ++) {
			ss = br.readLine().split(" ");
			
			for(int j = 0; j < M; j++) {
				A[i][j + 1] = Integer.parseInt(ss[j]);
			}
		}
		
		
		// 회전 연산 정보 입력
		int r, c, s;
		
		for(int i = 0; i < K; i++) {
			ss = br.readLine().split(" ");
			
			r = Integer.parseInt(ss[0]);
			c = Integer.parseInt(ss[1]);
			s = Integer.parseInt(ss[2]);
			
			nodes[i] = new Node(r, c, s);
		}
		
		// 배열 A의 최솟값을 찾기 위한 순열 함수 실행
		perm(0);
	}
	
	// 배열 돌리기
	static void spinArray(int ly, int lx, int ry, int rx, int[][] arr) {
		
		if(lx >= rx) {
			return;
		}
		
		int temp1, temp2, temp3;
		
		temp1 = arr[ly][rx];
		temp2 = arr[ry][rx];
		temp3 = arr[ry][lx];
		
		
		for(int i = rx; i >= lx; i--) {
			arr[ly][i] = arr[ly][i - 1];
		}
		
		
		spinArray(ly + 1, lx + 1, ry - 1, rx - 1, arr);
	}
	
	// 회전 순서가 주어질 때, 회전 연산의 결과 값을 반환
	static int spinArrayByNodes() {
		
		// 배열 복사
		int[][] temp = new int[N + 2][M + 2];
		
		for(int i = 1; i <= A.length; i++) {
			System.arraycopy(A[i], 1, temp[i], 1, A[0].length);
		}
		
		int lx, ly; // 좌상단
		int rx, ry; // 우하단
		
		for(Node node : nodes) {
			ly = node.r - node.s;
			lx = node.c - node.s;
			ry = node.r + node.s;
			rx = node.c + node.s;
			
			spinArray(ly, lx, ry, rx, temp);
		}
		
		int sum;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < A.length; i++) {			
			sum = Arrays.stream(temp[i]).sum();
			min = Integer.min(sum, min);
		}
		
		return min;
	}
	
	static void perm(int depth) {
		if(depth == K) {
			int result = spinArrayByNodes();
			Answer = Integer.min(Answer, result);
		}
		
		for(int i = depth; i < K; i++) {
			swap(depth, i);
			perm(depth + 1);
			swap(depth, i);
		}
	}
	
	static void swap(int x, int y) {
		Node temp = nodes[y];
		nodes[y] = nodes[x];
		nodes[x] = temp;
	}
	
	static class Node{
		int r;
		int c;
		int s;
		
		Node(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}
}
