class MyQueue:
    def __init__(self):
        self.st1 = deque()
        self.st2 = deque()
        self.front = -1

    def push(self, x: int) -> None:
        if not self.st1: self.front = x
        self.st1.append(x)

    def pop(self) -> int:
        if self.st2: ans = self.st2.pop()
        else:
            while self.st1:
                self.st2.append(self.st1.pop())
            ans = self.st2.pop()
        return ans

    def peek(self) -> int:
        if self.st2: return self.st2[-1]
        else: return self.front

    def empty(self) -> bool:
        return len(self.st1) == 0 and len(self.st2) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()