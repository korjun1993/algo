# 사전 자료형은 키(Key)와 값(Value)의 쌍을 데이터로 가지는 자료형입니다
# 앞서 다루었던 리스트나 튜플이 값을 순차적으로 저장하는 것과 대비됩니다
# 사전 자료형은 키와 값의 쌍을 데이터로 가지며, 원하는 변경 불가능한 자료형을 키로 사용할 수 있습니다.
# 데이터의 조회 및 수정에 있어서 O(1)의 시간에 처리할 수 있습니다.

data = dict()
data['사과'] = 'Apple'
data['바나나'] = 'Banana'
data['코코넛'] = 'Coconut'

print(data)

if '사과' in data:
    print("'사과'를 키로 가지는 데이터가 존재합니다.")

# 키 데이터만 담은 리스트
key_list = data.keys()
# 값 데이터 담은 리스트
value_lsit = data.values()
print(key_list)
print(list(key_list))

print(value_lsit)
print(list(value_lsit))

for key in key_list:
    print(data[key])

b = {
    '홍길동': 97,
    '이순신': 98
}
