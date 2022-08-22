# def convert(n, base):
#     result = ''
#     while n > 0:
#         n, r = divmod(n, base)
#         result = str(r) + result
#     return result


def solution(s):
    answer = [0, 0]
    while s != '1':
        answer[0] += 1
        answer[1] += s.count('0')
        s = bin(len(s.replace('0', '')))[2:]
    return answer

print(int('101010', 2))