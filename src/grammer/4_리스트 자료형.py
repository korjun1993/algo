# 리스트란?
# 여러 개의 데이터를 연속적으로 담아 처리하기 위해 사용하는 자료형
# 리스트 대신에 배열 혹은 테이블이라고 부르기도 합니다

# 리스트 초기화
# 리스트는 대괄호([])안에 원소를 넣어 초기화하며, 쉼표(,)로 원소를 구분합니다
# 비어 있는 리스트를 선언하고자할 때는 list() 혹은 간단히 []를 이용할 수 있습니다
# 리스트의 원소에 접근할 때는 인덱스(Index) 값을 괄호에 넣습니다

# 직접 데이터를 넣어 초기화
a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(a)

# 네 번째 원소만 출력
print(a[3])

# 크기가 N이고, 모든 값이 0인 1차원 리스트 초기화
n = 10
b = [0] * n
print(b)

# 뒤에서 첫 번쨰 원소 출력
print(a[-1])

# 뒤에서 세 번째 원소 출력
print(a[-3])

# 두 번째 원소부터 네 번째 원소까지
print(a[1:4])

# 리스트 컴프리헨션
# 0부터 9까지의 수를 포함하는 리스트
c = [i for i in range(50)]
print(c)

# 0부터 19까지의 수 중에서 홀수만 포함하는 리스트
d = [i for i in range(20) if i % 2 == 1]
print(d)

# 1부터 9까지의 수들의 제곱 값을 포함하는 리스트
e = [i * i for i in range(1, 10)]
print(e)

# N x M 크기의 2차원 리스트를 한 번에 초기화하는 방법
n = 4
m = 3
array = [[0] * m for _ in range(n)]
print(array)

# N x M 크기의 2차원 리스트 초기화 (잘못된 방법)
array = [[0] * m] * n
print(array)

array[1][1] = 5
print(array)

# 리스트 관련 기타 메서드
a = [1, 4, 3]
print("기본 리스트: ", a)

# 리스트에 원소 삽입
a.append(2)
print("삽입: ", a)

a.insert(2, 5)
print("중간삽입: ", a)

# 오름차순 정렬
a.sort()
print("오름차순 정렬: ", a)

# 내림차순 정렬
a.sort(reverse=True)
print("내림차순 정렬: ", a)

# 원소 뒤집기
a.reverse()
print("원소 뒤집기: ", a)

# 특정 값인 데이터 개수 세기
print("값이 3인 데이터 개수: ", a.count(3))

# 특정 값 데이터 삭제 (한개만 지운다)
a.remove(1)
print("값이 1인 데이터 삭제: ", a)

# 특정 값을 가지는 원소 모두 제거
a = [1, 2, 3, 4, 5, 5, 5]
remove_set = {3, 5}
result = [i for i in a if i not in remove_set]
print(result)