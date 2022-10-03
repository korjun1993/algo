n, m = map(int, input().split())
selected = [0] * m
visited = [False] * (n + 1)


# n개의 수 중에서 총 m개를 고르는 함수
def func(k):
    if k == m:
        for i in range(m):
            print(selected[i], end=' ')
        print()
        return

    for i in range(1, n + 1):
        if not visited[i]:
            selected[k] = i
            visited[i] = True
            func(k + 1)
            selected[k] = 0
            visited[i] = False

func(0)
