from dataclasses import dataclass
from Employee import *

@dataclass
class SalariedEmployee(Employee):
    def calculatePay(self, taxRate):
        return self.basePay - (self.basePay * taxRate)

    def monthlyBasePay(self):
        return self.basePay
