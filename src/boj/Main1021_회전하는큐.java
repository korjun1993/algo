import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main1021_회전하는큐 {

	public static int N, M, Answer;
	public static int[] datas; // 추출 원소
	public static String[] s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Integer> list = new LinkedList<>(); // 큐

		s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		// input target element
		datas = new int[M];

		s = br.readLine().split(" ");

		for (int i = 0; i < M; i++) {
			datas[i] = Integer.parseInt(s[i]);
		}

		// input queue
		for (int i = 1; i <= N; i++) {
			list.add(new Integer(i));
		}

		// process
		int tIdx, nIdx;
		int d1, d2;
		nIdx = 0;

		for (int i = 0; i < M; i++) {
			tIdx = list.indexOf(new Integer(datas[i])); // 목표위치
			d1 = Math.abs(nIdx - tIdx); // 움직일 거리
			if (tIdx > nIdx) { // 반대로 움직일 거리
				d2 = list.size() - tIdx + nIdx;
			} else {
				d2 = list.size() - nIdx + tIdx;
			}

			// 왼쪽이 최소거리...
			if (d1 < d2) {
				Answer += d1;
			}

			// 오른쪽이 최소거리...
			else {
				Answer += d2;
			}
			nIdx = tIdx;
			list.remove(tIdx);
		}
		System.out.println(Answer);
	} // main
}
