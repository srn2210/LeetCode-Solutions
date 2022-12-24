class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if obstacleGrid[0][0] == 1: return 0
        if obstacleGrid[len(obstacleGrid)-1][len(obstacleGrid[0])-1] == 1: return 0
        dp = [[0 for j in range(len(obstacleGrid[0]))] for i in range(len(obstacleGrid))]
        #print(obstacleGrid)
        for i in range(len(dp)):
            if obstacleGrid[i][0] == 0: dp[i][0] = 1
            else:
                break
        for i in range(len(dp[0])):
            if obstacleGrid[0][i] == 0: dp[0][i] = 1
            else:
                break
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                if obstacleGrid[i][j] != 1:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[len(obstacleGrid)-1][len(obstacleGrid[0])-1]