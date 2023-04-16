from collections import defaultdict

answer = 0
graph = defaultdict(list)
data = []
vis = [False] * 17


# 늑대가 w마리, 양이 s마리 따라올 때, v를 방문하는 함수
def solve(v, w, s):
    # v를 방문하고 정답을 업데이트한다.
    print(v)
    global answer
    vis[v] = True
    w += info[v]
    s += (info[v] == 0)
    answer = max(answer, s)

    for i in range(len(info)):
        if vis[i]:
            for j in graph[i]:  # 방문 가능한 지역 = 방문했던 곳의 인접지역
                if not vis[j] and w + info[j] < s + (info[j] == 0):  # 이미 방문한 곳 또는 늑대 수가 많아지는 곳은 방문하지 않는다.
                    solve(j, w, s)  # j를 방문한다.
                    #vis[j] = False


def solution(info, edges):
    global answer, graph, data
    data = info
    for a, b in edges:
        graph[a].append(b)
        graph[b].append(a)

    solve(0, 0, 0)
    return answer


info = [0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0]
edges = [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6], [3, 7], [4, 8], [6, 9], [9, 10]]
print(solution(info, edges))
