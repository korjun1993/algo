package programmers;

import java.util.Arrays;

public class Solution_순위검색 {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = solution(info, query);
    }

    private static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Employee employees[] = new Employee[info.length];

        for (int i = 0; i < info.length; i++) {
            String[] arr = info[i].split(" ");
            employees[i] = new Employee(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
        }

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replace("and", "").replace("  ", " ").split(" ");
            answer[i] = (int) Arrays.stream(employees).filter(e -> check(e, q)).count();
        }
        return answer;
    }

    static boolean check(Employee e, String[] q) {
        return (q[0].equals("-") || e.lang.equals(q[0])) && (q[1].equals("-") || e.job.equals(q[1])) && (q[2].equals("-") || e.career.equals(q[2])) && (q[3].equals("-") || e.favorite.equals(q[3])) && e.score >= Integer.parseInt(q[4]);
    }

    static class Employee {
        String lang;
        String job;
        String career;
        String favorite;
        int score;

        public Employee(String lang, String job, String career, String favorite, int score) {
            this.lang = lang;
            this.job = job;
            this.career = career;
            this.favorite = favorite;
            this.score = score;
        }
    }
}
