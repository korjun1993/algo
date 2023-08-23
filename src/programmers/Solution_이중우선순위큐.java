package programmers;

import java.util.Collections;
import java.util.LinkedList;

public class Solution_이중우선순위큐 {

	public int[] solution(String[] operations) {
		LinkedList<Integer> dq = new LinkedList<>();
		for (String cmd : operations) {
			process(dq, cmd);
		}
		if (dq.isEmpty()) {
			return new int[] {0, 0};
		}
		return new int[] {dq.peek(), dq.peekLast()};
	}

	public void process(LinkedList<Integer> dq, String cmd) {
		String[] opers = cmd.split(" ");
		String oper = opers[0];
		int val = Integer.parseInt(opers[1]);

		if (oper.equals("I")) {
			dq.add(val);
			return;
		}

		if (oper.equals("D")) {
			Collections.sort(dq);
			if (val == 1) {
				dq.removeFirst();
			} else {
				dq.removeLast();
			}
		}
	}
}
