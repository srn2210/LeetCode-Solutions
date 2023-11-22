class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        q = deque()
        vis = set()
        ans = []

        q.append([0,0])
        vis.add((0,0))
        while q:
            node = q.popleft()
            ans.append(nums[node[0]][node[1]])
            if node[0] + 1 < len(nums) and node[1] < len(nums[node[0]+1]) and (node[0]+1, node[1]) not in vis:
                q.append([node[0]+1, node[1]])
                vis.add((node[0]+1, node[1]))
            if node[1] + 1 < len(nums[node[0]]) and (node[0], node[1]+1) not in vis:
                q.append([node[0], node[1]+1])
                vis.add((node[0], node[1]+1))
        return ans