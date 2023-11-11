class Graph:

    def __init__(self, n: int, edges: List[List[int]]):
        d = int(1e8)
        self.graph = [[d] * n for _ in range(n)]

        for u, v, c in edges:
            self.graph[u][v] = c
        
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if i == j:
                        self.graph[i][j] = 0
                        continue
                    self.graph[i][j] = min(self.graph[i][k] + self.graph[k][j], self.graph[i][j])


    def addEdge(self, edge: List[int]) -> None:
        u, v, c = edge[0], edge[1], edge[2]

        if self.graph[u][v] > c:
            self.graph[u][v] = c
            self.update(u, v, c)

    def update(self, u: int, v: int, c: int) -> None:
        for i in range(len(self.graph)):
            for j in range(len(self.graph)):
                self.graph[i][j] = min(self.graph[i][u] + self.graph[v][j] + c, self.graph[i][j])

    def shortestPath(self, node1: int, node2: int) -> int:
        return self.graph[node1][node2] if self.graph[node1][node2] != int(1e8) else -1


# Your Graph object will be instantiated and called as such:
# obj = Graph(n, edges)
# obj.addEdge(edge)
# param_2 = obj.shortestPath(node1,node2)