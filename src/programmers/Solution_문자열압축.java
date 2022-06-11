package programmers;

/**
 * 테스트 1 〉	통과 (15.40ms, 78.9MB)
 * 테스트 2 〉	통과 (16.25ms, 99.5MB)
 * 테스트 3 〉	통과 (18.25ms, 79.5MB)
 * 테스트 4 〉	통과 (14.89ms, 84.3MB)
 * 테스트 5 〉	통과 (0.01ms, 73.7MB)
 * 테스트 6 〉	통과 (16.17ms, 80.8MB)
 * 테스트 7 〉	통과 (16.52ms, 83.5MB)
 * 테스트 8 〉	통과 (15.33ms, 74.1MB)
 * 테스트 9 〉	통과 (15.30ms, 83MB)
 * 테스트 10 〉	통과 (20.73ms, 90.7MB)
 * 테스트 11 〉	통과 (14.08ms, 79.9MB)
 * 테스트 12 〉	통과 (14.96ms, 75MB)
 * 테스트 13 〉	통과 (18.44ms, 87.5MB)
 * 테스트 14 〉	통과 (15.59ms, 81.4MB)
 * 테스트 15 〉	통과 (15.07ms, 86.5MB)
 * 테스트 16 〉	통과 (1.50ms, 75.7MB)
 * 테스트 17 〉	통과 (16.84ms, 79.4MB)
 * 테스트 18 〉	통과 (16.37ms, 80.8MB)
 * 테스트 19 〉	통과 (16.29ms, 84.7MB)
 * 테스트 20 〉	통과 (17.19ms, 85MB)
 * 테스트 21 〉	통과 (20.23ms, 80.3MB)
 * 테스트 22 〉	통과 (25.19ms, 86.6MB)
 * 테스트 23 〉	통과 (21.78ms, 84.5MB)
 * 테스트 24 〉	통과 (19.61ms, 92.4MB)
 * 테스트 25 〉	통과 (20.84ms, 76.8MB)
 * 테스트 26 〉	통과 (19.81ms, 89.7MB)
 * 테스트 27 〉	통과 (20.35ms, 89.4MB)
 * 테스트 28 〉	통과 (11.93ms, 80.7MB)
 */
public class Solution_문자열압축 {
    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        int answer = solution(s);
        System.out.println(answer);
    }

    private static int solution(String s) {
        int answer = s.length();

        // len 길이 단위로 문자열을 압축한다.
        for (int len = 1; len <= s.length() / 2; len++) {
            String temp = shorten(s, len);

            // 정답 갱신
            if (temp.length() < answer) answer = temp.length();
        }
        return answer;
    }

    private static String shorten(String str, int len) {
        String result = "";

        int count = 1;
        int winIdx = 0;
        int nxtIdx = len;
        String winStr = "";
        String nxtStr = "";

        while (nxtIdx + len <= str.length()) {
            winStr = str.substring(winIdx, winIdx + len);
            nxtStr = str.substring(nxtIdx, nxtIdx + len);

            if (winStr.equals(nxtStr)) {
                count++;
                nxtIdx += len;
            }

            else {
                if (count > 1) {
                    result += count;
                    count = 1;
                }
                result += winStr;
                winIdx = nxtIdx;
                nxtIdx += len;
            }
        }

        if (count > 1) {
            result += count + winStr;
        } else {
            result += nxtStr;
        }

        result += str.substring(nxtIdx);
        return result;
    }
}
