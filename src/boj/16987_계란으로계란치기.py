from copy import deepcopy

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
ans = 0


# v개의 계란을 깬 상태이며, [k, n] 계란을 깨는 함수
def solve(k, v):
    if k == n:
        global ans
        ans = max(ans, v)
        return

    # 자신이 이미 깨져있으면 한 칸 오른쪽 계란으로 넘어감
    if a[k][0] <= 0:
        solve(k + 1, v)
        return

    # 남은 계란을 전부 깨도 ans보다 많지 않으면 해볼 가치가 없음
    if v + 2 * (n - k) <= ans:
        return

    # 부딪칠 계란 찾기
    isallbroken = True
    for i in range(n):
        if i == k or a[i][0] <= 0:  # 자신 또는 깨진 계란을 선택할 수 없음
            continue
        isallbroken = False
        a[i][0] -= a[k][1]
        a[k][0] -= a[i][1]
        solve(k + 1, v + (a[k][0] <= 0) + (a[i][0] <= 0))
        a[i][0] += a[k][1]
        a[k][0] += a[i][1]
    if isallbroken:
        solve(k + 1, v)


solve(0, 0)
print(ans)
