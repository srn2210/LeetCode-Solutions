class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        res = []
        for arr in intervals :
            if len(res) == 0 or res[-1][1] < arr[0] :
                res.append(arr)
            else :
                res[-1][1] = max(res[-1][1], arr[1])
        return res