package exercise;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = {10, 2, 4, 7, 1, 6, 5, 12, 11, 8, 7};

		for (int i = 1; i < numbers.length; i++) {
			int key = numbers[i];
			int j = i - 1; // 정렬된 집합의 가장 오른쪽 위치
			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = key;
		}

		System.out.println(Arrays.toString(numbers));
	}
}
