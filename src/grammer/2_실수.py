# 양의 실수
a = 157.93
print(a)

# 음의 실수
a = -1837.2
print(a)

# 소수부가 0일 때 0을 생략
a = 5.
print(a)

# 정수부가 0일 때 0을 생략
a = -.7
print(a)

# 1,000,000,000의 지수 표현 방식
a = 1e9
print(a)

# 752.5
a = 75.25e1
print(a)

# 3.954
a = 3954e-3
print(a)

# 2진수에서는 0.9를 정확히 표현할 수 있는 방법이 없습니다
a = 0.3 + 0.6
print(a)
if a == 0.9:
    print(True)
else:
    print(False)

# 반올림을 해서 0.9로 만들어보자
a = round(a, 4)
print(a)
if a == 0.9:
    print(True)
else:
    print(False)