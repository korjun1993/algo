package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_두큐합같게만들기 {
	public int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = asQueue(queue1);
		Queue<Integer> q2 = asQueue(queue2);
		long sum1 = Arrays.stream(queue1).sum();
		long sum2 = Arrays.stream(queue2).sum();
		int count = 0;
		while (count < q1.size() + q2.size()) {
			count++;
			if (sum1 > sum2) {
				int peek = q1.poll();
				q2.add(peek);
				sum1 -= peek;
				sum2 += peek;
			} else if (sum1 < sum2) {
				int peek = q2.poll();
				q1.add(peek);
				sum2 -= peek;
				sum1 += peek;
			} else {
				break;
			}
		}
		return count;
	}

	public Queue<Integer> asQueue(int[] queue) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int e : queue) {
			list.add(e);
		}
		return list;
	}
}
