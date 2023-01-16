class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        ans = []
        for i in range(len(intervals)):
            if intervals[i][1] < newInterval[0]:
                ans.append(intervals[i])
            elif newInterval[1] < intervals[i][0]:
                ans.append(newInterval)
                newInterval = intervals[i]
            else:
                newInterval[0] = min(newInterval[0], intervals[i][0])
                newInterval[1] = max(newInterval[1], intervals[i][1])
        ans.append(newInterval)
        return ans
                    