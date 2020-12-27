# 2020. 12. 26. 핸드폰번호 가리기
# 슬라이싱을 통해 쉽게 풀었다.
def solution(phone_number):
    return '*' * (len(phone_number)-4) + phone_number[-4:]