package exercise;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers = {10, 2, 4, 7, 1, 6, 5, 12, 11, 8, 7};

		for (int i = 0; i < numbers.length - 1; i++) {
			int min = numbers[i];
			int minIdx = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < min) {
					min = numbers[j];
					minIdx = j;
				}
			}
			int temp = numbers[i];
			numbers[i] = min;
			numbers[minIdx] = temp;
		}

		System.out.println(Arrays.toString(numbers));
	}
}
