from dataclasses import dataclass

@dataclass
class Employee:
    name: str
    basePay: float

    def calculatePay(self, taxRate):
        raise NotImplementedError

    def monthlyBasePay(self):
        raise NotImplementedError
