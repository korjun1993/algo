import re

p = re.compile('(100+1+|01)+')
data = input()
print("NOISE" if p.fullmatch(data) is None else "SUBMARINE")
