class NumArray:
    arr = []
    bit = []
    def __init__(self, nums: List[int]):
        self.arr = [0 for i in range(len(nums))]
        for i in range(len(nums)): self.arr[i] = nums[i]
        self.bit = [0 for i in range(len(nums)+1)]
        for i in range(len(nums)):
            self.update1(i+1, nums[i])

    def update1(self, i: int, val: int) -> None:
        while i <= len(self.arr):
            self.bit[i] += val
            i += (i & -i)
            
    def sum(self, i: int):
        ans = 0
        while i > 0:
            ans += self.bit[i]
            i -= (i & -i)
        return ans
    
    def update(self, index: int, val: int) -> None:
        self.update1(index+1, val - self.arr[index])
        self.arr[index] = val

    def sumRange(self, left: int, right: int) -> int:
        return self.sum(right+1) - self.sum(left)

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)