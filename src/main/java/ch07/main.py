import sys

employees = ["직원A", "직원B", "직원C"]
basePays = [400, 300, 250]

def getTaxRate():
    return float(input('세율을 입력하세요: '))

def calculatePayFor(name, taxRate):
    index = employees.index(name)
    basePay = basePays[index]
    return basePay - (basePay * taxRate)

def describeResult(name, pay):
    return '이름: {0}, 급여: {1}'.format(name, pay)

def sumOfBasePays():
    result = 0
    for basePay in basePays:
        result += basePay
    print(result)

def calculatePay(name):
    if name not in employees:
        print('올바른 이름을 입력하세요.')
        return
    taxRate = getTaxRate()
    pay = calculatePayFor(name, taxRate)
    print(describeResult(name, pay))

def main(argv):
    if argv:
        calculatePay(argv[0])
    else:
        sumOfBasePays()

if __name__ == "__main__":
    main(sys.argv[1:])
