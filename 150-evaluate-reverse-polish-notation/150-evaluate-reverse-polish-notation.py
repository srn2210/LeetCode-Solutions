class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if len(tokens) == 1:
            return int(tokens[0])
        
        stack = []
        
        for s in tokens:
            if s == "+":
                a = stack.pop()
                b = stack.pop()
                stack.append(b+a)
            elif s == "-":
                a = stack.pop()
                b = stack.pop()
                stack.append(b-a)
            elif s == "*":
                a = stack.pop()
                b = stack.pop()
                stack.append(b*a)
            elif s == "/":
                a = stack.pop()
                b = stack.pop()
                stack.append(int(b/a))
            else:
                stack.append(int(s))
        
        return stack.pop()