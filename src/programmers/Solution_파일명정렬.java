package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_파일명정렬 {
    class File implements Comparable<File> {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            int compValue = head.compareToIgnoreCase(o.head);
            if (compValue == 0) {
                return Integer.parseInt(number) - Integer.parseInt(o.number);
            }
            return compValue;
        }

        @Override
        public String toString() {
            return head + number + tail;
        }
    }

    public String[] solution(String[] record) {
        String[] answer = new String[record.length];
        List<File> files = new ArrayList<>();
        for (String rec : record) {
            String head = null;
            String number = null;
            String tail = null;
            int i, j;
            for (i = 0; i < rec.length(); i++) {
                if (Character.isDigit(rec.charAt(i))) {
                    head = rec.substring(0, i);
                    break;
                }
            }
            for (j = i; j < rec.length(); j++) {
                if (!Character.isDigit(rec.charAt(j))) {
                    number = rec.substring(i, j);
                    break;
                }
            }
            if (number == null) {
                number = rec.substring(i, j);
            }
            tail = rec.substring(j, rec.length());
            files.add(new File(head, number, tail));
        }
        Collections.sort(files);
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            answer[i] = file.toString();
        }
        return answer;
    }
}
