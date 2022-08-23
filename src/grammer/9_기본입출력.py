# input() : 한 줄의 문자열을 입력 받는 함수
# map() : 리스트의 모든 원소에 각각 특정한 함수를 적용할 때 사용

# 예시) 공백을 기준으로 구분된 데이터를 입력 받을 때는 다음과 같이 사용합니다.
# list(map(int, input().split()))

# 예시) 공백을 기준으로 구분된 데이터의 개수가 많지 않다면, 단순히 다음과 같이 사용합니다.
# a, b, c = map(int, input().split())

# 데이터의 개수 입력
n = int(input())
data = list(map(int, input().split()))

print(n)
print(data)

a, b, c = map(int, input().split())
#
# # 빠르게 입력 받기
import sys
# 문자열 입력 받기
data = sys.stdin.readline().rstrip()
print(data)

# 출력할 변수들
a = 1
b = 2
print(a, b)
print(7, end=" ")
print(8, end=" ")

# 출력할 변수
answer= 7
print("정답은 " + str(answer) + "입니다.")

# f-string 예제
answer = 7
print(f'정답은 {answer}입니다.')

