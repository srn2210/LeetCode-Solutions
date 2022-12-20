class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        vis = [False for i in range(len(rooms))]
        q = deque()
        for i in rooms[0]:
            q.append(i)
        vis[0] = True
        while q:
            t = q.popleft()
            if not vis[t]:
                for j in rooms[t]:
                    if not vis[j]: q.append(j)
            vis[t] = True
        res = True
        for i in vis:
            res &= i
        return res