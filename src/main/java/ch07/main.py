import sys
from Employee import *

employees = [
    Employee("직원A", 400, False, 0),
    Employee("직원B", 300, False, 0),
    Employee("직원C", 250, False, 0),
    Employee("알바D", 1, True, 120),
    Employee("알바E", 1, True, 120),
    Employee("알바F", 1.5, True, 120),
]

def getTaxRate():
    return float(input('세율을 입력하세요: '))

def describeResult(name, pay):
    return '이름: {0}, 급여: {1}'.format(name, pay)

def calculatePay(name):
    taxRate = getTaxRate()
    employee = None
    for e in employees:
        if e.name == name:
            employee = e
            break
    pay = employee.calculatePay(taxRate)
    print(describeResult(name, pay))

def sumOfBasePays():
    result = 0
    for employee in employees:
        result += employee.monthlyBasePay()
    print(result)

def main(argv):
    if argv:
        calculatePay(argv[0])
    else:
        sumOfBasePays()

if __name__ == "__main__":
    main(sys.argv[1:])
