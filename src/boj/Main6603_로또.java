package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length;
		int[] S;
		String line;
		Stack<Integer> stack;

		StringTokenizer st;
		while ((line = br.readLine()).charAt(0) != '0') {
			st = new StringTokenizer(line);

			length = Integer.parseInt(st.nextToken());
			S = new int[length];
			stack = new Stack<Integer>();

			for (int i = 0; i < length; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			comb(S, stack, 0, 6);
			System.out.println();
		}
	}

	private static void comb(int[] s, Stack<Integer> stack, int offset, int k) {
		if (k == 0) {
			Iterator<Integer> it = stack.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
			return;
		}
		for (int i = offset; i <= s.length - k; i++) {
			stack.push(s[i]);
			comb(s, stack, i + 1, k - 1);
			stack.pop();
		}
	}
}
