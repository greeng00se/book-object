import sys
from employees import *

def getTaxRate():
    return float(input('세율을 입력하세요: '))


def describeResult(name, pay):
    return '이름: {0}, 급여: {1}'.format(name, pay)

def main(argv):
    if argv:
        calculatePay(argv[0])
    else:
        sumOfBasePays()

if __name__ == "__main__":
    main(sys.argv[1:])
