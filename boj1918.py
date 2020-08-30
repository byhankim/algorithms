icp = {'+':1, '-':1, '*':2, '/':2, '(':3}
isp = {'(':0, '+':1, '-':1, '*':2, '/':2}
opr = []
opr_token = "*/+-()"
ipt = '(' + input() + ')'

for ch in ipt:
    if ch in opr_token:
        if ch == ')':
            while opr[len(opr)-1] != '(': print(opr.pop(), end='')
            opr.pop() # 여는 괄호 버리기
        else: #    닫는 괄호 제외한 (, *, /, +, - 일 경우
            if ch == '(': opr.append(ch)
            elif icp[ch] > isp[opr[len(opr)-1]]: opr.append(ch)
            else:
                while icp[ch] <= isp[opr[len(opr)-1]]: print(opr.pop(), end='')
                opr.append(ch)
    elif ch not in opr_token: print(ch, end='')