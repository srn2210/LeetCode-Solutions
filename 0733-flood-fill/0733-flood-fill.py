class Solution:
    def dfs(self, image: List[List[int]], sr: int, sc: int, init: int, color: int) -> None:
        if sr < 0 or sr >= len(image) or sc < 0 or sc >= len(image[0]) or image[sr][sc] != init: return
        image[sr][sc] = color
        self.dfs(image, sr + 1, sc, init, color)
        self.dfs(image, sr, sc + 1, init, color)
        self.dfs(image, sr - 1, sc, init, color)
        self.dfs(image, sr, sc - 1, init, color)
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color: return image
        self.dfs(image, sr, sc, image[sr][sc], color)
        return image