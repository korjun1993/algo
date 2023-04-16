def isvalidate(s):
    opened = ['[', '(', '{']
    closed = [']', ')', '}']
    stack = []
    for c in s:
        if stack and stack[-1] in opened and c in closed and opened.index(stack[-1]) == closed.index(c):
            stack.pop()
        else:
            stack.append(c)

    return False if stack else True


def solution(s):
    answer = 0
    for _ in range(len(s)):
        s = s[1:] + s[0]
        if isvalidate(s):
            answer += 1
    return answer