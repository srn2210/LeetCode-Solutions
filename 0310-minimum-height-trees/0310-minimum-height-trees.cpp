class Solution {
  vector<vector<int>> g;

 public:
  int bfs(int src, int n) {
    vector<int> vis(n, -1), dis(n, 0);
    queue<int> q;
    q.push(src);
    while (!q.empty()) {
      int cur = q.front();
      q.pop();
      vis[cur] = 1;
      for (int x : g[cur]) {
        if (vis[x] == -1) {
          dis[x] = dis[cur] + 1;
          q.push(x);
        }
      }
    }
    int max_dis = INT_MIN, vertex;
    for (int i = 0; i < n; i++) {
      if (dis[i] > max_dis) {
        max_dis = dis[i];
        vertex = i;
      }
    }
    return vertex;
  }

  vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
    g.resize(n);
    for (int i = 0; i < edges.size(); i++) {
      g[edges[i][0]].push_back(edges[i][1]);
      g[edges[i][1]].push_back(edges[i][0]);
    }
    int start = bfs(0, n);
    int end = bfs(start, n);
    vector<int> parent(n), vis(n, 0);
    queue<int> q;
    parent[start] = -1;
    q.push(start);
    while (!q.empty()) {
      int cur = q.front();
      q.pop();
      vis[cur] = 1;
      for (int child : g[cur]) {
        if (vis[child] == 0) {
          parent[child] = cur;
          q.push(child);
        }
      }
    }
    vector<int> path;
    while (end != -1) {
      path.push_back(end);
      end = parent[end];
    }
    if (path.size() % 2 == 0) {
      return {path[path.size() / 2], path[path.size() / 2 - 1]};
    }
    return {path[path.size() / 2]};
  }
};