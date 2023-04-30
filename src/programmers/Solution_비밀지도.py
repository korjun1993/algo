def solution(n, arr1, arr2):
    board1 = []
    board2 = []
    answer = []
    for row in range(n):
        board1.append(list(str(format(arr1[row], '0b')).zfill(n)))
        board2.append(list(str(format(arr2[row], '0b')).zfill(n)))
        tmp = []
        for col in range(n):
            if board1[row][col] and board2[row][col]:
                tmp.append('#')
            else:
                tmp.append(' ')
        answer.append(''.join(tmp))
    return answer