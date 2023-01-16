class Solution:
    class UnionFind:
        def __init__(self, n: int):
            self.arr = []
            self.size = []
            for i in range(n):
                self.arr.append(i)
                self.size.append(1)
        def find(self, p: int) -> int:
            if p == self.arr[p]: return p
            self.arr[p] = self.find(self.arr[p])
            return self.arr[p]
        def union(self, p: int, q: int):
            x = self.find(p)
            y = self.find(q)
            if x == y: return
            if self.size[x] < self.size[y]:
                self.arr[x] = self.arr[y]
                self.size[y] += self.size[x]
            else:
                self.arr[y] = self.arr[x]
                self.size[x] += self.size[y]
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        obj = self.UnionFind(len(vals))
        adj = [[] for i in range(len(vals))]
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        m1 = defaultdict(list)
        ans = 0
        for i in range(len(vals)):
            m1[vals[i]].append(i)
        for i, val in sorted(m1.items()):
            for node in val:
                for neighbours in adj[node]:
                    if vals[neighbours] <= vals[node]:
                        obj.union(node, neighbours)
            m2 = defaultdict(int)
            for node in val:
                m2[obj.find(node)] += 1
            for x, y in m2.items():
                ans += (y * (y + 1)) // 2
        return ans