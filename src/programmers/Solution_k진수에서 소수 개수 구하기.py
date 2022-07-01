# def solution(n, k):
#     answer = 0
#     number = convert(n, k)
#     list = []
#     temp = ""
#
#     for i in range(len(number)):
#         if number[i] != "0":
#             temp += number[i]
#             if i + 1 == len(number):
#                 list.append(temp)
#         else:
#             if temp != "":
#                 list.append(temp)
#                 temp = ""
#             list.append(number[i])
#
#     for i in range(len(list)):
#         if isPrime(list[i]):
#             if 0 < i < len(list) - 1 and list[i - 1] == "0" and list[i + 1] == "0":
#                 answer += 1  # 0P0
#             elif i == 0 and len(list) > 1 and list[i + 1] == "0":
#                 answer += 1  # P0
#             elif i == len(list) - 1 and len(list) > 1 and list[i - 1] == "0":
#                 answer += 1  # 0P
#             elif len(list) == 1:
#                 answer += 1  # P
#
#     return answer
#
#
# def convert(number, base):
#     result = ""
#     while (number > 0):
#         result = str(number % base) + result
#         number = number // base
#     return result
#
#
# def isPrime(number):
#     number = int(number)
#     if 0 <= number <= 1:
#         return False
#
#     for i in range(2, int(number ** 0.5)):
#         if number % i == 0:
#             return False
#
#     return True


def solution(n, k):
    answer = 0
    print(convert(n, k).split('0'))

    for str in convert(n, k).split('0'):
        if isPrime(int(str)) : answer += 1

    return answer

def convert(number, base):
    result = ""
    while (number > 0):
        result = str(number % base) + result
        number = number // base
    return result


def isPrime(number):
    if number <= 1: return False
    for i in range(2, int(number ** 0.5) + 1):
        if number % i == 0: return False
    return True

result = solution(110011, 10)
print(result)
