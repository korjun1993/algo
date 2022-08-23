# 파이썬에서 함수는 여러 개의 반환 값을 가질 수 있습니다.

def operator(a, b):
    add_var = a + b
    subtract = a - b
    multiply_var = a * b
    divide_var = a / b
    return add_var, subtract, multiply_var, divide_var


a, b, c, d = operator(7, 3) # unpacking
print(a, b, c, d)
