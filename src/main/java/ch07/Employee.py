from dataclasses import dataclass

@dataclass
class Employee:
    name: str
    basePay: float
    hourly: bool
    timeCard: int

    def calculatePay(self, taxRate):
        if self.hourly:
            return self.__calculateHourlyPay(taxRate)
        return self.__calculateSalariedPay(taxRate)

    def monthlyBasePay(self):
        if self.hourly:
            return 0
        return self.basePay

    def __calculateHourlyPay(self, taxRate):
        pay = self.basePay * self.timeCard
        return pay - (pay * taxRate)

    def __calculateSalariedPay(self, taxRate):
        return self.basePay - (self.basePay * taxRate)

