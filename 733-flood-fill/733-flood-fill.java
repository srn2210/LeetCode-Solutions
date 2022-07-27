class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;
        image[sr][sc] = color;
        
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir:directions) {
                int row = cur[0] + dir[1];
                int col = cur[1] + dir[0];
                if(row >= image.length || row < 0 || col >= image[0].length || col < 0 || image[row][col] != oldColor) continue;
                image[row][col] = color;
                queue.add(new int[]{row,col});
            }
        }
        
        return image;
    }
}