def etc():
    print("내장함수목록=", dir([1, 2, 3, 4]))


def number_format():
    print("쉼표 단위로 끊어 출력=", format(100000000, ','))  # 100,000,000
    print("이진수로 출력=", format(1000, '0b'))  # 1111101000
    print("십진수로 출력=", format(0b111, '#d'))  # 7
    print("길이출력=", len([1, 2, 3, 4, 5, 6]))  # 6


def math():
    data = [1, 2, 3]
    print("합=", sum(data))  # 1 + 2 + 3

    # 가장 작은 값 반환
    print("가장작은값=", min(data))  # 1
    print("가장작은값=", min(1, 2, 3, 4, 5))  # 1

    # 가장 큰 값 반환
    print("가장큰값=", max(data))  # 3

    # 계산식 연산
    print("계산식연산=", eval("(3+5)*7"))  # 56


def sort():
    # 오름차순 정렬
    data = [2, 4, 5, 6, 1, 2, 10, 0]
    print("오름차순정렬=", sorted(data))  # [0, 1, 2, 2, 4, 5, 6, 10]

    # 내림차순 정렬
    print("내림차순정렬=", sorted(data, reverse=True))  # [10, 6, 5, 4, 2, 2, 1, 0]

    # List, Dict 정렬
    data = [{"key": 4}, {"key": 5}, {"key": 2}, {"key": 1}, {"key": 3}]
    data.sort(key=lambda x: x['key'])
    print("오름차순정렬=", data)  # [{'key': 1}, {'key': 2}, {'key': 3}, {'key': 4}, {'key': 5}]

    data.sort(key=lambda x: x['key'], reverse=True)
    print("내림차순정렬=", data)  # [{'key': 5}, {'key': 4}, {'key': 3}, {'key': 2}, {'key': 1}]

    # List, Tuple 정렬
    data = [("A", 4), ("A", 3), ("B", 1), ("C", 3), ("D", 2), ("B", 10), ("E", 5)]
    data.sort(key=lambda x: (x[0], -x[1]))
    print("튜플의 첫번째 원소는 오름차순정렬, 두번째 원소는 내림차순정렬=",
          data)  # [('A', 4), ('A', 3), ('B', 10), ('B', 1), ('C', 3), ('D', 2), ('E', 5)]

    # 길이순으로 정렬
    testcase1 = ['abc', 'def', 'hello world', 'hello', 'python']
    testcase2 = 'Life is too short, You need python'.split()
    print("문자열 길이순으로 정렬=", sorted(testcase1, key=len))  # ['abc', 'def', 'hello', 'python', 'hello world']
    print("문자열 알파벳순으로 정렬=", sorted(testcase2))  # ['Life', 'You', 'is', 'need', 'python', 'short,', 'too']
    print("문자열 알파벳순으로 정렬(대소구분X)=",
          sorted(testcase2, key=str.lower))  # ['is', 'Life', 'need', 'python', 'short,', 'too', 'You']


def commonly_use():
    data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    print("람다를 이용한 filter 사용 = ", list(filter(lambda x: x % 2 == 0, data)))  # [2, 4, 6, 8, 10]
    print("람다를 이용한 map 사용 ", list(map(lambda x: x % 2 == 0, data)))  # [Fasle, True, False, True, ...]
    print(list(zip(['a', 'b', 'c'], [1, 2, 3], [True, False, True],
                   'ABCD')))  # [('a', 1, True), ('b', 2, False), ('c', 3, True)]

    print("5가 리스트안에 포함되는가?=", 5 in [1, 2, 3, 4, 5])  # True


def list_api():
    data = [1, 2, 3, 4, 5]

    # 데이터 삽입 위치 조회
    print("5의 인덱스=", data.index(5))  # 4
    # print("숫자가 리스트에 없을때 인덱스=", data.index(8))  # 에러발생

    # 데이터 추가
    data.append(8)  # [1,2,3,4,5,8]

    # 데이터 삭제
    print("마지막원소제거 =", data.pop())  # 8 => [1,2,3,4,5]
    print("인덱스 위치하는 원소제거", data.pop(0))  # 1 => [2,3,4,5]

    # 복사
    newone = data.copy()
    print("복사본=", newone)


def queue():
    data = [1, 2, 3, 4, 5]
    data.append(6)
    print(data.pop(0))  # 1


def stack():
    data = [1, 2, 3, 4, 5]
    data.append(6)
    print(data.pop())  # 6


def dict_api():
    d = {'one': '하나', 'two': '둘'}

    # 데이터 조회
    print("키만뽑기=", list(d.keys()))
    print("값만뽑기=", list(d.values()))
    print("둘다뽑기=", list(d.items()))

    # 데이터 추가
    d['three'] = '셋'
    print("데이터 추가=", d)

    # 데이터 삭제
    del (d['three'])
    print("데이터 삭제=", d)


def set_api():
    s = set('111223334456')  # {'5', '4', '1', '2', '6', '3'}

    # 데이터 추가
    s.add(7)
    print("데이터추가=", s)  # {7, '5', '4', '1', '2', '6', '3'}

    # 삭제
    s.discard(7)
    print("데이터삭제=", s)  # {'5', '4', '1', '2', '6', '3'}

    # 차집합
    k = {'8', '1', '2'}
    print("차집합=", s.difference(k))  # {'3', '6', '4', '5'}

    # 교집합
    print("교집합=", s.intersection(k))  # {'1', '2'}

    # 합집합
    print("합집합=", s.union(k))  # {'5', '1', '4', '6', '2', '3', '8'}


def string():
    # 문자열 더해서 연결하기
    head = "python"
    tail = " is fun"
    print("문자열 연결하기 = ", head + tail)  # python is fun

    # 문자열 곱하기
    print("문자열 곱하기 = ", head * 3)  # pythonpythonpython

    # 문자열 길이
    print("문자열 길이 = ", len(head))  # 6

    # 문자열 슬라이싱
    print("문자열 슬라이싱 = ", head[0:3])  # pyt

    # 문자열 포매팅
    x = 10
    y = 5
    print("현재 온도는 %d 입니다. 현재 습도는 %d 입니다." % (x, y))

    # 문자 세기
    print("문자 세기", head.count('p'))  # python 에서 p 는 0개 있다

    # 위치 알려주기
    print("인덱스 찾기", head.index('p'))  # python 에서 0번째 위치에 p가 있다

    # 문자열 삽입
    data = ",".join('abcd')
    print("abcd 문자열 각 사이에 쉼표 넣기 =", data)  # a,b,c,d

    # 소문자를 대문자로 바꾸기
    a = "hi"
    print("hi를 대문자로 바꾸기 = ", a.upper())  # HI

    # 대문자를 소문자로 바꾸기
    a = "BYE"
    print("대문자를 소문자로 바꾸기 = ", a.lower())  # bye

    # 왼쪽 공백 지우기
    a = "    hi"
    print("왼쪽 공백 하나 지우기 = ", a.lstrip())

    # 오른쪽 공백 지우기
    a = "hi   "
    print("오른쪽 공백 하나 지우기 = ", a.lstrip())

    # 양쪽 공백 지우기
    a = " hi "
    print("양쪽 공백 하나 지우기 = ", a.strip())

    # 문자열 바꾸기
    a = "Life is too short"
    print("문자열 바꾸기", a.replace("Life", "Your leg"))  # Your leg is too short

    # 문자열 나누기
    b = 'a:b:c:d'
    print("문자열 나누기 = ", b.split(':'))


def quiz():
    # 단톡방에 x마리의 동물이 대화를 하고 있습니다.
    # 각각의 동물들이 톡을 전송할 때마다 서버에는 아래와 같이 저장됩니다.
    # 1. 단톡방에는 모두 몇 마리의 동물이 있을까요? 톡은 무조건 1회 이상 전송합니다.
    # 2. 단톡방에 동물들마다 몇 번의 톡을 올렸을까요?
    data = '개리 라이캣 개리 개리 라이캣 자바독 자바독 파이 썬 호준'
    talk = data.split()
    animal = set(talk)
    print("동물 수 =", len(animal))
    from collections import Counter
    print("각 동물의 톡 수=", dict(Counter(talk)))


commonly_use()
list_api()
dict_api()
set_api()
string()
quiz()

# Reference
# [Youtube] 파이썬 코딩 테스트에 자주 나오는 라이브러리 정리 - 채널 빅공잼
# [Youtube] Python 코딩 테스트 보기 전!! final 메서드 정리 하시고 가세요!! - 채널 제주코딩베이스캠프
# https://www.youtube.com/watch?v=IPEgysPFRKI
# https://www.youtube.com/watch?v=bepntLy33gA