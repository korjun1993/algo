from collections import defaultdict

N = int(input())
S = input()
cnt = defaultdict(int)
R = 0
kind = 0
ans = 0

for L in range(len(S)):
    # 현재까지 탐색한 문자 종류가 N개 이하이면 계속 탐색한다.
    while R < len(S) and kind <= N:
        if cnt[S[R]] == 0:
            if kind == N:
                break
            kind += 1

        # 탐색한 수의 등장횟수 +1
        cnt[S[R]] += 1
        R += 1
    ans = max(ans, R - L)

    # L번째 문자 발견횟수를 -1
    cnt[S[L]] -= 1

    # 탐색집합에서 사라진다면 kind - 1
    if cnt[S[L]] == 0:
        kind -=1

print(ans)