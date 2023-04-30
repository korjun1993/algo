from bisect import bisect_right
import copy


def getminute(time):
    return int(time[:2]) * 60 + int(time[3:])


def gethour(time):
    divide, remain = divmod(time, 60)
    return str(divide).zfill(2) + ":" + str(remain).zfill(2)


def determine(timetable, n, t, m, mid):
    tmp = copy.deepcopy(timetable)
    waitnum = bisect_right(tmp, mid)  # 기다리는 순서
    tmp.insert(waitnum, mid)
    first = 0  # 버스도착시 처음탈 사람번호
    for i in range(n):
        bustime = 540 + i * t  # 버스 출발하는 시간(분)
        cnt = 0  # 탑승한 사람수
        for j in range(m):
            if first + j < len(tmp) and tmp[first + j] <= bustime:
                cnt += 1
                if first + j == waitnum:
                    return True
        first += cnt
    return False


def solution(n, t, m, timetable):
    timetable = [t for t in timetable if t != "23:59"]
    timetable = list(map(getminute, timetable))
    timetable.sort()
    ans = 0
    lo = 0
    hi = 1438
    while lo <= hi:
        mid = (lo + hi) // 2
        if determine(timetable, n, t, m, mid):
            lo = mid + 1
            ans = max(ans, mid)
        else:
            hi = mid - 1
    return gethour(ans)