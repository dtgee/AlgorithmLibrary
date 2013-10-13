import sys
import fileinput
import os

__author__ = "Lucas Ou-Yang"

class Balance:
    BASE_WEIGHT = 10
    balanceNum = None
    leftBalance = None
    rightBalance = None
    leftWeight = None
    rightWeight = None
    # "Height" as in how high up it's
    # stacked on other balances, 0 is ground level
    height = 0
    addedLeft = 0
    addedRight = 0

    def __init__(self, num, lw, rw, lb, rb):
        self.balanceNum = num
        self.leftBalance = lb
        self.rightBalance = rb
        self.leftWeight = lw
        self.rightWeight = rw

    def getTotalWeight(self):
        total = 0
        for bal in (self.rightBalance + self.leftBalance):
            total += BALANCES[bal].getTotalWeight()
        total += self.BASE_WEIGHT + self.leftWeight + self.rightWeight
        return total

    def getTotalLeftWeight(self):
        weight = self.leftWeight
        for bal in self.leftBalance:
            weight += BALANCES[bal].getTotalWeight()
        return weight

    def getTotalRightWeight(self):
        weight = self.rightWeight
        for bal in self.rightBalance:
            weight += BALANCES[bal].getTotalWeight()
        return weight

    def isBalanced(self):
        if self.getTotalLeftWeight() == self.getTotalRightWeight():
            return True
        return False

# the program is based off of a dictionary of balances, key'ed by their
# ascending balance number
BALANCES = {}
def main():
    input = sys.stdin.readlines()

    # current var set, will be reset each new two iterations
    chunks = None
    leftWeight = None
    rightWeight = None
    leftBalance = []
    rightBalance = []

    balIndex = 0
    for num, line in enumerate(input):
        if num == 0:
            pass
        else:
            chunks = line.rstrip().split(" ") # Strip out all new lines prior to splitting
            # odd line implies that it's on the left hand side
            if num % 2 == 1:
                leftWeight = int(chunks[0])
                for balance in chunks[1:]:
                    leftBalance.append(int(balance))

            # even line implies that it's on the right hand side
            else:
                rightWeight = int(chunks[0])
                for balance in chunks[1:]:
                    rightBalance.append(int(balance))

                BALANCES[balIndex] = Balance(balIndex, leftWeight, rightWeight, leftBalance, rightBalance)
                balIndex += 1

                # reset values after appending the new balance
                leftWeight = None
                rightWeight = None
                leftBalance = []
                rightBalance = []

    # Create height levels by breadth first traversing the balances
    # balances and accumulating the heights of the lower balances
    # however, some balances (balance 20.... <.<) are on height zero also! so we must compute this
    # for all ground zero balances
    groundZeros = [x for x in BALANCES.values() if x.height == 0]
    for b in groundZeros:
        computeBreadthFirstHeight(b)

    # Evaluate the newly made list of balances, sort by height first so
    # we eval the top balances first, to maximize bottom added weights
    sortedBals = sorted(BALANCES.items(), key=lambda x: x[1].height, reverse=True)

    for balNum in sortedBals:
        balance = BALANCES[balNum[0]]
        if not balance.isBalanced():
            left = balance.getTotalLeftWeight()
            right = balance.getTotalRightWeight()
            if left > right:
                balance.rightWeight += left - right
                balance.addedRight = left - right
            elif right > left:
                balance.leftWeight += right - left
                balance.addedLeft = right - left

    for b in BALANCES.items():
        print str(b[0]) + ": " + str(b[1].addedLeft) + " " + str(b[1].addedRight)

def computeBreadthFirstHeight(balance):
    onThisBal = []
    if not balance.leftBalance and not balance.rightBalance:
        return
    for bal in balance.leftBalance:
        onThisBal.append(BALANCES[bal])
    for bal in balance.rightBalance:
        onThisBal.append(BALANCES[bal])
    # the below isn't super optimized, but its easier for me to think this way
    for b in onThisBal:
        b.height = balance.height + 1
    for b in onThisBal:
        computeBreadthFirstHeight(b)

if __name__ == "__main__":
    main()