def math():
    from math import factorial
    print("팩토리얼=", factorial(3))  # 3 * 2 * 1

    from math import sqrt
    print("제곱근=", sqrt(4))  # 2.0

    from math import gcd, lcm
    print("4와 2의 최대공약수=", gcd(4, 2))  # 2

    print("17, 5의 최대공배수=", lcm(17, 5))  # 85

    from math import pi, e
    print("원주율=", pi)  # 3.141592
    print("자연지수=", e)  # 2.718

    from math import ceil
    # 올림
    print("올림=", ceil(12.34))  # 13
    print("올림=", ceil(-12.34))  # -12

    from math import floor
    # 내림
    print("내림", floor(12.34))  # 12
    print("내림", floor(-12.34))  # -13

    from math import trunc
    # 소수점 버림
    print("소수점버림", trunc(12.34))  # 12
    print("소수점버림", trunc(-12.34))  # -12

    # 반올림
    print("소수 첫번째 자리에서 반올림", round(12345.6789))  # 12346
    print("소수 두번째 자리에서 반올림", round(12345.6789, 1))  # 12346.7
    print("소수 세번째 자리에서 반올림", round(12345.6789, 2))  # 12346.68

    # 사사오입 원칙
    # 반올림 대상의 값이 5일 때 앞자리 숫자가 홀수면 올림, 짝수면 내림
    print(round(1.5))  # 2
    print(round(2.5))  # 2
    print(round(3.5))  # 4
    print(round(4.5))  # 4


def priority_queue():
    import heapq

    data = [1, 3, 5, 7, 9, 2, 4, 6, 8, 0]

    # 기존 리스트를 힙으로 변환
    heapq.heapify(data)
    print("리스트를 힙으로 변환=", data)

    # 힙에 데이터 담기
    h = []
    for i in range(10):
        heapq.heappush(h, i)
    print("힙=", h)  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    # 힙 데이터 pop
    while h:
        print(heapq.heappop(h))  # 0, 1, 2, 3, 4, 5 , 6, 7, 8, 9
    print()


def collections():
    # collections
    # 유용한 자료구조를 제공하는 표준 라이브러리
    from collections import deque

    data = deque([2, 3, 4])

    data.appendleft("appendleft")
    data.append("appendright")
    print(data)  # deque(['appendleft', 2, 3, 4, 'appendright'])

    print("마지막원소=", data.pop())  # appendright
    print("첫번째원소=", data.popleft())  # appendleft

    from collections import Counter
    data = ["Apple", "Apple", "Banana", "Melon", "Kiwi"]
    counter = dict(Counter(data))
    print(counter)  # {'Apple': 2, 'Banana': 1, 'Melon': 1, 'Kiwi': 1}


def binary_search():
    from bisect import bisect_left, bisect_right

    data = [1, 4, 6, 2, 2, 3, 18, 192, 39, 5]
    data.sort()  # [1, 2, 2, 3, 4, 5, 6, 18, 39, 192]

    print("이진탐색(2를 대입할 위치 중 맨 왼쪽)=", bisect_left(data, 2))

    print("이진탐색(2를 대입할 위치 중 맨 오른쪽)=", bisect_right(data, 2))


def iterabletools():
    # itertools 함수
    # 파이썬에서 반복되는 데이터를 처리하는 기능을 포함하고 있는 라이브러리
    from itertools import permutations

    data = ["A", "B", "C"]
    data = list(permutations(data, 3))
    print("A,B,C 에서 3개를 순서를 고려하여 나열=",
          data)  # [('A', 'B', 'C'), ('A', 'C', 'B'), ('B', 'A', 'C'), ('B', 'C', 'A'), ('C', 'A', 'B'), ('C', 'B', 'A')]

    from itertools import combinations

    data = ["가", "나", "다", "라"]
    data = list(combinations(data, 2))
    print("가,나,다,라 에서 2개를 순서 고려없이 뽑기=",
          data)  # [('가', '나'), ('가', '다'), ('가', '라'), ('나', '다'), ('나', '라'), ('다', '라')]

    from itertools import product

    data = [1, 2, 3, 4]
    data = list(product(data, repeat=3))
    print("1,2,3,4 에서 3개를 순서를 고려하여 나열(중복가능)",
          data)  # [(1, 1, 1), (1, 1, 2), (1, 1, 3), (1, 1, 4), (1, 2, 1), (1, 2, 2), (1, 2, 3), (1, 2, 4), (1, 3, 1), (1, 3, 2), (1, 3, 3), (1, 3, 4), (1, 4, 1), (1, 4, 2), (1, 4, 3), (1, 4, 4), (2, 1, 1), (2, 1, 2), (2, 1, 3), (2, 1, 4), (2, 2, 1), (2, 2, 2), (2, 2, 3), (2, 2, 4), (2, 3, 1), (2, 3, 2), (2, 3, 3), (2, 3, 4), (2, 4, 1), (2, 4, 2), (2, 4, 3), (2, 4, 4), (3, 1, 1), (3, 1, 2), (3, 1, 3), (3, 1, 4), (3, 2, 1), (3, 2, 2), (3, 2, 3), (3, 2, 4), (3, 3, 1), (3, 3, 2), (3, 3, 3), (3, 3, 4), (3, 4, 1), (3, 4, 2), (3, 4, 3), (3, 4, 4), (4, 1, 1), (4, 1, 2), (4, 1, 3), (4, 1, 4), (4, 2, 1), (4, 2, 2), (4, 2, 3), (4, 2, 4), (4, 3, 1), (4, 3, 2), (4, 3, 3), (4, 3, 4), (4, 4, 1), (4, 4, 2), (4, 4, 3), (4, 4, 4)]

    from itertools import combinations_with_replacement

    data = ["duck", "bird", "tree", "bag"]
    data = list(combinations_with_replacement(data, 3))
    print("duck, bird, tree, bag 에서 순서없이 중복허용하여 3개뽑기=", data)
    print()


math()
priority_queue()
iterabletools()
binary_search()
collections()
