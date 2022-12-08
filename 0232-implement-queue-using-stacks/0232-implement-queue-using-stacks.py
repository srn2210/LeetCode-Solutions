class MyQueue:
    #st1
    #st2
    #front
    def __init__(self):
        self.st1 = deque()
        self.st2 = deque()
        self.front = -1

    def push(self, x: int) -> None:
        self.st1.append(x)
        if self.front == -1: self.front = x

    def pop(self) -> int:
        while self.st1:
            self.st2.append(self.st1.pop())
        ans = self.st2.pop()
        if self.st2: self.front = self.st2[-1]
        else: self.front = -1
        while self.st2:
            self.st1.append(self.st2.pop())
        return ans

    def peek(self) -> int:
        return self.front

    def empty(self) -> bool:
        return len(self.st1) == 0


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()