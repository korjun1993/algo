package codetree.시뮬레이션.격자안에서밀고당기기;

import java.util.Scanner;

public class 최단RunLength인코딩 {
	public static String A;

	// 오른쪽으로 Shfit
	public static String shift(String s) {
		char[] chars = s.toCharArray();
		int size = chars.length;

		char temp = chars[size - 1];
		for (int i = size - 1; i > 0; i--) {
			chars[i] = chars[i - 1];
		}
		chars[0] = temp;

		return String.valueOf(chars);
	}

	// Run Length 인코딩
	public static int encode(String s) {
		StringBuilder encoded = new StringBuilder();
		char[] ch = s.toCharArray();
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (ch[i] == ch[i - 1]) {
				count++;
			} else {
				encoded.append(ch[i - 1]).append(count);
				count = 1;
			}
		}
		encoded.append(ch[s.length() - 1]).append(count);
		return encoded.length();
	}

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		A = sc.next();

		// abcdefghij -> a1b1c1d1e1f1g1h1i1j1
		int answer = 20;

		for (int i = 0; i < A.length(); i++) {
			A = shift(A);
			answer = Math.min(answer, encode(A));
		}

		System.out.println(answer);
	}
}
