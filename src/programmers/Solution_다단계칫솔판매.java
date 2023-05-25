package programmers;

import java.util.*;

public class Solution_다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> index = new HashMap<>();
        List<Integer>[] adj = new List[enroll.length + 1];
        List<Integer>[] earn = new List[enroll.length + 1];

        index.put("-", 0);
        for (int i = 0; i < enroll.length; i++) {
            index.put(enroll[i], i + 1);
        }

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
            earn[i] = new LinkedList<>();
        }

        for (int i = 0; i < referral.length; i++) {
            int indexOfEnroll = index.get(referral[i]);
            adj[indexOfEnroll].add(i + 1);
        }

        for (int i = 0; i < seller.length; i++) {
            int indexOfSeller = index.get(seller[i]);
            earn[indexOfSeller].add(amount[i] * 100);
        }

        solve(0, -1, adj, earn);
        int[] answer = new int[enroll.length];
        for (int i = 1; i < earn.length; i++) {
            for (int money : earn[i]) {
                answer[i - 1] += money;
            }
        }
        return answer;
    }

    private void solve(int node, int pre, List<Integer>[] adj, List<Integer>[] earn) {
        for (int child : adj[node]) {
            if (child == pre) continue;
            solve(child, node, adj, earn);
            for (int i = 0; i < earn[child].size(); i++) {
                int childEarn = earn[child].get(i);
                int tip = (int) (childEarn * 0.1);
                if (tip < 1) continue;
                earn[node].add(tip);
                earn[child].set(i, childEarn - tip);
            }
        }
    }

//    public static void main(String[] args) {
//        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//        String[] seller = {"young", "john", "tod", "emily", "mary"};
//        int[] amount = {12, 4, 2, 5, 10};
//        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
//    }
}
