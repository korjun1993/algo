package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main5373_큐빙 {
    static enum Turn {
        UP('U',
                new int[]{11, 10, 9, 51, 52, 53, 29, 28, 27, 20, 19, 18},
                new int[]{0, 1, 2, 5, 8, 7, 6, 3}),
        DOWN('D',
                new int[]{15, 16, 17, 24, 25, 26, 33, 34, 35, 47, 46, 45},
                new int[]{36, 37, 38, 41, 44, 43, 42, 39}),
        FRONT('F',
                new int[]{6, 7, 8, 27, 30, 33, 38, 37, 36, 17, 14, 11},
                new int[]{18, 19, 20, 23, 26, 25, 24, 21}),
        BACK('B',
                new int[]{9, 12, 15, 42, 43, 44, 35, 32, 29, 2, 1, 0},
                new int[]{45, 46, 47, 50, 53, 52, 51, 48}),
        LEFT('L',
                new int[]{0, 3, 6, 18, 21, 24, 36, 39, 42, 45, 48, 51},
                new int[]{11, 14, 17, 16, 15, 12, 9, 10}),
        RIGHT('R',
                new int[]{2, 5, 8, 47, 50, 53, 38, 41, 44, 20, 23, 26},
                new int[]{33, 30, 27, 28, 29, 32, 35, 34});

        private final char face;    // 돌리는 면
        private final int[] effected; // effected[0]: 영향가는 12개의 위치
        private final int[] rotated; // 90도 회전되는 8개위치

        private Turn(char face, int[] effected, int[] rotated) {
            this.face = face;
            this.effected = effected;
            this.rotated = rotated;
        }

        public static void doTurn(char param) {
            int[] effected = Objects.requireNonNull(Arrays.stream(values())
                    .filter(turn -> turn.face == param)
                    .findFirst().orElse(null))
                    .effected;

            int[] rotated = Objects.requireNonNull(Arrays.stream(values())
                    .filter(turn -> turn.face == param)
                    .findFirst().orElse(null))
                    .rotated;

            char[] que = new char[12];

            // 영향가는 12개 위치 회전
            for (int i = 0; i < 12; i++) {
                que[i] = cube[effected[i]];
            }
            for (int i = 0; i < 12; i++) {
                cube[effected[(i + 3) % 12]] = que[i];
            }
            // 바라보는 면 회전
            que = new char[8];
            for (int i = 0; i < 8; i++) {
                que[i] = cube[rotated[i]];
            }
            for (int i = 0; i < 8; i++) {
                cube[rotated[(i + 2) % 8]] = que[i];
            }
        }
    }

    static char[] cube;
    static int T;   // 테스트케이스의 개수
    static int N;   // 큐브를 돌린 수
    static String[] turnInfo;   // 큐브를 돌리는 방법
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            input();
            pro();
        }
    }

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        turnInfo = br.readLine().split(" ");
    }

    private static void pro() {
        init();
        for (String ti : turnInfo) {
            turn(ti);
        }
        printResult();
    }

    private static void turn(String ti) {
        char face = ti.charAt(0); // 회전 위치에 대한 정보
        char dir = ti.charAt(1); // 회전 방향에 대한 정보

        // 반시계 방향 회전 = 시계 방향 회전 x 3
        int count = 1;
        if (dir == '-') {
            count = 3;
        }

        while (count-- > 0) {
            Turn.doTurn(face);
        }
    }

    // 큐브의 처음 상태를 초기화한다.
    private static void init() {
        cube = new char[]{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w',
                'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g',
                'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r',
                'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
                'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y',
                'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'
        };
    }

    private static void printResult() {
        for (int i = 0; i < 9; i++) {
            System.out.print(cube[i]);
            if (i > 0 && i % 3 == 2) {
                System.out.println();
            }
        }
    }
}
