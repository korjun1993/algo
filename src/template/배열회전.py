def rotate_row1(arr, row, k):
    m = len(arr[row])
    k %= m
    if k != 0:
        arr[row] = arr[row][-k:m] + arr[row][0:m - k]
    return arr


def rotate_row2(arr, row, k):
    from collections import deque
    d = deque(arr[row])
    d.rotate(k)
    arr[row] = list(d)
    return arr


def rotate_col1(arr, col, k):
    from collections import deque
    # [(1,4,7), (2,5,8), (3,6,9)]
    a = [list(t) for t in list(zip(*arr))]
    b = deque(a[col])
    b.rotate(k)
    a[col] = list(b)
    print(a)
    return [list(t) for t in list(zip(*a))]


def rotate_col2(arr, col, k):
    k = k % len(arr)
    a = [arr[i - k][col] for i in range(len(arr))]
    print(a)

arr = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
arr = rotate_col2(arr, 0, 1)