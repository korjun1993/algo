from collections import Counter


def solution(a):
    counter = Counter(a)
    maxlen = 0
    for k, v in counter.items():
        if maxlen > 2 * v:
            continue
        selected = 0
        i = 0  # 탐색할 배열의 인덱스
        j = 0  # 현재까지 고른 부분수열의 길이
        while i < len(a):
            if j % 2 == 0:
                selected = a[i]  # 첫번째 원소는 아무거나
                j += 1
            else:
                if selected == k:  # 두번째 원소는 첫번째 원소의 반대
                    while i < len(a):
                        if a[i] != k:
                            j += 1
                            break
                        i += 1

                elif selected != k:
                    while i < len(a):
                        if a[i] == k:
                            j += 1
                            break
                        i += 1
            i += 1

        maxlen = max(maxlen, j)
    return 2 * (maxlen // 2)
