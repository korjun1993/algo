def solution(a):
  answer = 0
  check = [False] * len(a)
  for _ in range(2):
    min = 1000000001
    for i in range(len(a)):
        if a[i] < min:
            min = a[i]
            if not check[i]:
                check[i] = True
                answer += 1
    a.reverse()
    check.reverse()
  return answer