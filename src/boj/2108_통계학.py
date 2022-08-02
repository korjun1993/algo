from collections import Counter
N = int(input())
a = [int(input()) for _ in range(N)]
a.sort()
print(round(sum(a) / N)) # 산술평균
print(a[N//2]) # 중앙값
c = Counter(a)
if len(c) == 1: # 최빈값
  c = c.most_common(1)
  print(c[0][0])
else:
  c = c.most_common(2)
  print(c[0][0] if c[0][1] > c[1][1] else c[1][0])
print(a[N - 1] - a[0]) # 범위