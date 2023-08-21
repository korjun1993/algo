package programmers;

import java.util.LinkedList;
import java.util.List;

public class Solution_불량사용자 {
	public static int answer;
	public static String[] userId;
	public static String[] bannedId;
	public static List<Integer> select = new LinkedList<>();
	public static boolean[] visited = new boolean[11111111];

	public static int solution(String[] user_id, String[] banned_id) {
		// 편의를 위해 정적 멤버로 선언
		userId = user_id;
		bannedId = banned_id;

		solve(0);
		System.out.println(answer);

		return answer;
	}
	public static void solve(int indexNum) {
		if (indexNum == bannedId.length) {
			if (validate()) {
				push();
			}
			return;
		}
		for (int i = 0; i < userId.length; i++) {
			if (select.contains(i)) continue;
			select.add(i);
			solve(indexNum + 1);
			select.remove(indexNum);
		}
	}

	private static void push() {
		int cur = 0;
		for (int i : select) {
			cur = cur | 1 << i;
		}
		if (!visited[cur]) {
			visited[cur] = true;
			answer++;
		}
	}

	private static boolean validate() {
		for (int i = 0; i < bannedId.length; i++) {
			if (isDiffrent(bannedId[i], userId[select.get(i)])) {
				return false;
			}
		}
		return true;
	}

	// str1: *를 포함한 bannedId
	// str2: userId
	private static boolean isDiffrent(String str1, String str2) {
		if (str1.length() != str2.length()) return true;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == '*') continue;
			if (str1.charAt(i) != str2.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**", "******"});
	}
}
