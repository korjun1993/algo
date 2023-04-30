package programmers;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution_스킬체크테스트Level3 {
    class Job implements Comparable<Job> {
        int endTime;
        int coreIdx;

        public Job(int endTime, int coreIdx) {
            this.endTime = endTime;
            this.coreIdx = coreIdx;
        }

        @Override
        public int compareTo(Job o) {
            if (endTime == o.endTime) return coreIdx - o.coreIdx;
            return endTime - o.endTime;
        }
    }

    public int solution(int n, int[] cores) {
        int ans = 0;
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
        PriorityQueue<Integer> waitCoreQueue = new PriorityQueue<>();

        for (int coreIdx = 0; coreIdx < cores.length; coreIdx++) {
            waitCoreQueue.add(coreIdx);
        }

        // 초기 작업 시작
        for (int coreIdx = 0; coreIdx < cores.length; coreIdx++) {
            if (n > 0) {
                jobQueue.add(new Job(cores[coreIdx], coreIdx));
                waitCoreQueue.poll();
                n--;
            } else {
                break;
            }
        }

        while (n > 0) {
            // 작업을 끝낸다.
            Job endJob = jobQueue.poll();
            int currentTime = endJob.endTime;
            int waitCoreIdx = endJob.coreIdx;

            // 코어 대기 명단에 방금 일을 마친 코어를 추가한다.
            waitCoreQueue.add(waitCoreIdx);

            // 코어 대기 명단에서 가장 앞의 코어에게 일을 시킨다.
            while (!waitCoreQueue.isEmpty()) {
                int coreIdx = waitCoreQueue.poll();
                jobQueue.add(new Job(currentTime + cores[coreIdx], coreIdx));
                n--;
            }
        }

        Iterator<Job> it = jobQueue.iterator();
        while (it.hasNext()) {
            ans = it.next().coreIdx;
        }
        return ans;
    }
}
