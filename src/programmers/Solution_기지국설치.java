package programmers;

public class Solution_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 첫 번째 구간에 대한 기지국 개수 구하기
        int left = 1;
        int right = stations[0] - w - 1;
        answer += getStationNumber(left, right, w);

        // 중간 구간에 대한 기지국 개수 구하기
        for (int i = 0; i < stations.length - 1; i++) {
            left = stations[i] + w + 1;
            right = stations[i + 1] - w - 1;
            answer += getStationNumber(left, right, w);
        }

        // 마지막 구간에 대한 기지국 개수 구하기
        left = stations[stations.length - 1] + w + 1;
        right = n;
        answer += getStationNumber(left, right, w);
        return answer;
    }

    public int getStationNumber(int left, int right, int w) {
        int bound = 2 * w + 1;
        int len = right - left + 1;
        if (len <= 0) return 0;
        return (int) Math.ceil((double) len / bound);
    }
}
