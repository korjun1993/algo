package exercise;

import java.util.Arrays;

public class MergeSort {
	public static int[] sorted = new int[11];

	public static void main(String[] args) {
		int[] numbers = {10, 2, 4, 7, 1, 6, 5, 12, 11, 8, 7};
		mergeSort(numbers, 0, numbers.length - 1);
		System.out.println(Arrays.toString(numbers));
	}

	public static void mergeSort(int[] numbers, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(numbers, start, mid);
			mergeSort(numbers, mid + 1, end);
			merge(numbers, start, mid, end);
		}
	}

	public static void merge(int[] numbers, int start, int mid, int end) {
		int left = start;
		int right = mid + 1;
		int idx = start; // idx: start~end에 해당하는 인덱스, 이곳에 정렬된 숫자를 기록할 거임

		while (left <= mid && right <= end) {
			if (numbers[left] <= numbers[right]) {
				sorted[idx++] = numbers[left++];
			} else {
				sorted[idx++] = numbers[right++];
			}
		}

		// left가 mid를 넘어버림
		// => right 요소들이 남아있다
		if (left > mid) {
			for (int i = right; i <= end; i++) {
				sorted[idx++] = numbers[i];
			}
		} else { // left가 mid를 넘지못함 => left 요소들이 남아있다
			for (int i = left; i <= mid; i++) {
				sorted[idx++] = numbers[i];
			}
		}

		for (int i = start; i <= end; i++) {
			numbers[i] = sorted[i];
		}
	}
}
