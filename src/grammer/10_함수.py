a = 10
array = [1, 2, 3, 4, 5]


def func():
    # global 키워드로 변수를 지정하면 해당 함수에서는 지역 변수를 만들지 않고, 함수 바깥에 선언된 변수를 바로 참조하게 된다.
    a += 1


def func2():
    # 함수 호출은 가능함
    array.append(6)
    print(array)


def func3():
    array = [3, 4, 5]
    array.append(6)
    print(array) # 실행결과: [3, 4, 5, 6] (지역변수 참조가 우선임)


def func4():
    global array
    array.append(6)
    print(array)  # 실행결과: [1,2, 3, 4, 5, 6] (global 키워드에 의해 전역변수 참조)
