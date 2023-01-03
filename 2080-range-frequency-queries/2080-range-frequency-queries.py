class RangeFreqQuery:
    arr1 = []
    m = dict()
    def __init__(self, arr: List[int]):
        self.arr1 = arr
        self.m = dict()
        for i in range(len(arr)):
            if arr[i] not in self.m:
                self.m[arr[i]] = []
            self.m[arr[i]].append(i)

    def query(self, left: int, right: int, value: int) -> int:
        if value not in self.m: return 0
        one = self.bSearch(0, len(self.m[value])-1, self.m[value], left)
        two = self.bSearch(0, len(self.m[value])-1, self.m[value], right)
        if one < 0 and two < 0 and one == two: return 0
        one = -one-1 if one < 0 else one
        two = -two-2 if two < 0 else two
        return two - one + 1

    def bSearch(self, left: int, right: int, arr: List[int], val: int) -> int:
        while left <= right:
            mid = left + (right - left) // 2
            if arr[mid] == val: return mid
            elif val < arr[mid]: right = mid - 1
            else: left = mid + 1
        return -left-1
    
# Your RangeFreqQuery object will be instantiated and called as such:
# obj = RangeFreqQuery(arr)
# param_1 = obj.query(left,right,value)