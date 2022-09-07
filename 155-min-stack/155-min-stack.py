class MinStack:
    def __init__(self):
        self.arr = []
        self.ans = []

    def push(self, val: int) -> None:
        self.arr.append(val)
        if len(self.ans) > 0:
            self.ans.append(min(val, self.ans[-1]))
        else:
            self.ans.append(val)

    def pop(self) -> None:
            self.arr.pop()
            self.ans.pop()

    def top(self) -> int:
        return self.arr[-1]

    def getMin(self) -> int:
        return self.ans[-1]