n = int(input())
a = list(map(int, input().split()))
a.sort()
max = 3000000000
ans = []


# x 보다 같거나 작은 수 중, 가장 왼쪽 수의 위치를 리턴
def lower_bound(left, right, x):
    result = left
    while left <= right:
        mid = (left + right) // 2
        if a[mid] <= x:
            result = mid
            left = mid + 1
        else:
            right = mid - 1
    return result


for i in range(n - 2):
    for j in range(i + 1, n - 1):
        cand = lower_bound(j + 1, n - 1, -(a[i] + a[j]))
        if abs(a[i] + a[j] + a[cand]) < max:
            max = abs(a[i] + a[j] + a[cand])
            ans = [i, j, cand]

        if cand < n - 1 and abs(a[i] + a[j] + a[cand + 1]) < max:
            max = abs(a[i] + a[j] + a[cand + 1])
            ans = [i, j, cand + 1]

        if cand > j + 1 and abs(a[i] + a[j] + a[cand - 1]) < max:
            max = abs(a[i] + a[j] + a[cand - 1])
            ans = [i, j, cand - 1]

print(a[ans[0]], a[ans[1]], a[ans[2]])