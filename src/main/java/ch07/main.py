import sys

employees = ["직원A", "직원B", "직원C", "알바D", "알바E", "알바F"]
basePays = [400, 300, 250, 1, 1, 1.5]
hourlys = [False, False, False, True, True, True]
timeCards = [0, 0, 0, 120, 120, 120]

def getTaxRate():
    return float(input('세율을 입력하세요: '))

def calculatePayFor(name, taxRate):
    index = employees.index(name)
    basePay = basePays[index]
    return basePay - (basePay * taxRate)

def calculateHourlyPayFor(name, taxRate):
    index = employees.index(name)
    basePay = basePays[index] * timeCards[index]
    return basePay - (basePay * taxRate)

def isHourly(name):
    return hourlys[employees.index(name)]

def describeResult(name, pay):
    return '이름: {0}, 급여: {1}'.format(name, pay)

def sumOfBasePays():
    result = 0
    for index, basePay in enumerate(basePays):
        result += basePay if not hourlys[index] else 0
    print(result)

def calculatePay(name):
    if name not in employees:
        print('올바른 이름을 입력하세요.')
        return

    taxRate = getTaxRate()
    pay = 0
    if isHourly(name):
        pay = calculateHourlyPayFor(name, taxRate)
    else:
        pay = calculatePayFor(name, taxRate)

    print(describeResult(name, pay))

def main(argv):
    if argv:
        calculatePay(argv[0])
    else:
        sumOfBasePays()

if __name__ == "__main__":
    main(sys.argv[1:])
