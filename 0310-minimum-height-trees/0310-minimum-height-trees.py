class Solution:
    def dfs(self, src: int, adj: List[List[int]], prev: int) -> List[int]:
        if len(adj[src]) == 1 and prev == adj[src][0]: return [0, src]
        dist = 0
        e = -1
        for edge in adj[src]:
            if edge != prev:
                t = self.dfs(edge, adj, src)
                t[0] += 1
                if t[0] > dist:
                    dist = t[0]
                    e = t[1]
        return [dist, e]
    p = []
    def dfs2(self, src: int, adj: List[List[int]], prev: int, end: int) -> bool:
        if len(adj[src]) == 1 and prev == adj[src][0]:
            if src == end:
                self.p.append(end)
                return True
            else: return False
        for edge in adj[src]:
            if edge != prev:
                if self.dfs2(edge, adj, src, end):
                    self.p.append(src)
                    return True
        return False
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n <= 2:
            ans = [i for i in range(n)]
            return ans
        adj = [[] for _ in range(n)]
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        vis = set()
        start = self.dfs(0, adj, -1)[1]
        end = self.dfs(start, adj, -1)[1]
        self.p = []
        self.dfs2(start, adj, -1, end)
        if len(self.p) % 2 == 0:
            return [self.p[len(self.p)//2], self.p[len(self.p)//2-1]]
        else:
            return [self.p[len(self.p)//2]]