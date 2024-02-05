package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1759_암호만들기 {
	static int L, C;
	static int[] selected;
	static String[] alphabets;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		input();
		Arrays.sort(alphabets);
		recursive_func(1, 0, 0);
		System.out.println(sb.toString());
	}

	private static void recursive_func(int k, int vowel_cnt, int consonant_cnt) {
		if (k == L + 1) {
			if (vowel_cnt > 0 && consonant_cnt > 1) {
				for (int i = 1; i <= L; i++)
					sb.append(alphabets[selected[i] - 1]);
				sb.append("\n");
			}
			return;
		}

		for (int cand = selected[k - 1] + 1; cand <= C; cand++) {
			selected[k] = cand;
			if ("aeiou".contains(alphabets[cand - 1]))
				recursive_func(k + 1, vowel_cnt + 1, consonant_cnt);
			else
				recursive_func(k + 1, vowel_cnt, consonant_cnt + 1);
			selected[k] = 0;
		}
	}

	private static void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] str = br.readLine().split(" ");
			L = Integer.parseInt(str[0]);
			C = Integer.parseInt(str[1]);
			alphabets = br.readLine().split(" ");
			selected = new int[L + 1];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

