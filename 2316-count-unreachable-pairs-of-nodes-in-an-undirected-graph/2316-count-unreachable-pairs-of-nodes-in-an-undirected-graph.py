class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        adj = [[] for _ in range(n)]
        
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        
        visited = [False] * n
        
        def dfs(node: int) -> int:
            count = 1
            visited[node] = True
            for e in adj[node]:
                if not visited[e]:
                    count += dfs(e)
            return count
        
        ans = 0
        
        for i in range(n):
            if not visited[i]:
                nodes = dfs(i)
                n -= nodes
                ans += nodes * n
                
        return ans