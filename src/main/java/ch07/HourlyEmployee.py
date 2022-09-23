from dataclasses import dataclass
from Employee import *

@dataclass
class HourlyEmployee(Employee):
    timeCard: int

    def calculatePay(self, taxRate):
        pay = self.basePay * self.timeCard
        return pay - (pay * taxRate)

    def monthlyBasePay(self):
        return 0
