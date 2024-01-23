import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493_탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		Stack<Integer> value = new Stack<Integer>();
		Stack<Integer> idx = new Stack<Integer>();
		int peek, now;

		int T = Integer.parseInt(br.readLine());

		String str = br.readLine();
		st = new StringTokenizer(str, " ");

		// 1번째 푸시
		value.push(Integer.parseInt(st.nextToken()));
		idx.push(1);
		System.out.print(0 + " ");

		for (int i = 2; i <= T; i++) {
			now = Integer.parseInt(st.nextToken());
			peek = value.peek(); // 가장 가까이 있는 기준

			// peek에 부딪힐 수 없으면...
			if (peek < now) {
				
				// 자신보다 낮은건 다 버린다
				while (!value.isEmpty() && value.peek() < now) {
					value.pop();
					idx.pop();
				}
				
				if (value.isEmpty()) {
					bw.write(0 + " ");
				}
				
				else {
					bw.write(idx.peek() + " ");
				}
				
				value.push(now);
				idx.push(i);
			}

			// peek에 부딪히면...
			else {
				bw.write(idx.peek() + " ");
				value.push(now);
				idx.push(i);
			}
		}
		br.close();
        bw.close();
	}
}
