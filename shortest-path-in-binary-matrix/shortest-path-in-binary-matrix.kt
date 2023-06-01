class Solution {
    fun isSafe(x: Int, y: Int, grid: Array<IntArray>, vis: Array<BooleanArray>): Boolean {
        return x >= 0 && y >= 0 && x < grid.size && y < grid.size && grid[x][y] != 1 && !vis[x][y]
    }
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if(grid[0][0] == 1) return -1
        val n = grid.size
        val directions = arrayOf(intArrayOf(1,0), intArrayOf(0,1), intArrayOf(-1,0), intArrayOf(0,-1), intArrayOf(1,1), intArrayOf(1,-1), intArrayOf(-1,1), intArrayOf(-1,-1))
        var q : Queue<IntArray> = LinkedList<IntArray>()
        var vis = Array(n) {BooleanArray(n)}
        q.add(intArrayOf(0,0))
        var distance = 1
        vis[0][0] = true
        while(!q.isEmpty()) {
            var size = q.size
            while(size-- > 0) {
                var arr = q.remove()
                if(arr[0] == n-1 && arr[1] == n-1) return distance
                for(dir in directions) {
                    var x = arr[0] + dir[0]
                    var y = arr[1] + dir[1]
                    if(isSafe(x, y, grid, vis)) {
                        vis[x][y] = true
                        q.add(intArrayOf(x,y))
                    }
                }
            }
            distance++
        }
        return -1
    }
}