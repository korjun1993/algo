package exercise;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] numbers = {10, 2, 4, 7, 1, 6, 5, 12, 11, 8};

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(numbers));
	}
}
