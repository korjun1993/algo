# itertools : 파이썬에서 반복되는 형태의 데이터를 처리하기 위한 유용한 기능들을 제공
# 특히 순열과 좋바 라이브러리는 코딩 테스트에서 자주 사용된다.

# heapq : 힙(Heap) 자료구조를 제공합니다.
# 일반적으로 우선순위 큐 기능을 구현하기 위해 사용됩니다.

# bisect : 이진 탐색(Binary search) 기능을 제공합니다.

# collections: 덱(deque), 카운터(counter) 등의 유용한 자료구조를 포함합니다.

# math : 필수적인 수학적 기능을 제공합니다.
# 팩토리얼, 제곱근, 최대공약수(GCD), 삼각함수 관련 함수부터 파이(PI)와 같은 상수를 포함합니다.

# sum()
result = sum([1, 2, 3, 4, 5])
print(result)

# min(), max()
min_result = min(7, 3, 5, 2)
max_result = max(7, 3, 5, 2)
print(min_result, max_result)

# eval()
result = eval("(3+5)*7")
print(result)

# sorted()
result = sorted([9, 1, 5, 8, 5, 2])
reversed_result = sorted([9, 1, 5, 8, 5, 2], reverse=True)
print(result)
print(reversed_result)

# sorted() with key
array = [('홍길동', 35), ('이순신', 75), ('아무개', 50)]
result = sorted(array, key=lambda x: x[1], reverse=True)
print(result)

# Counter
# 리스트와 같은 반복 가능한(iterable) 객체가 주어졌을 때 내부의 원소가 몇 번씩 등장했는지를 알려줍니다.
from collections import Counter

counter = Counter(['red', 'blue', 'red', 'green', 'blue', 'blue'])
print(counter['blue'])
print(counter['green'])
print(dict(counter))

# 최대공약수와 최소공배수
import math

print(math.gcd(21, 14))
print(21 * 14 // math.gcd(21, 14))

# 순열과 조합
from itertools import permutations
from itertools import combinations
from itertools import product
from itertools import combinations_with_replacement

data = ['A', 'B', 'C']

# 순열
result = permutations(data, 3)
print(list(result))

# 조합
result = combinations(data, 2)
print(list(result))

# 중복 순열
result = product(data, repeat=2)
print(list(result))

# 중복 조합
result = combinations_with_replacement(data, 2)
print(list(result))
