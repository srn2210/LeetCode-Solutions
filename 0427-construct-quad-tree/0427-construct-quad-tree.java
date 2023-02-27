/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    Node construct(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd, Node node) {
        if(rowStart == rowEnd && colStart == colEnd) {
            node.isLeaf = true;
            if(grid[rowStart][colStart] == 1) node.val = true;
            return node;
        }
        boolean one = false;
        boolean zero = false;
        for(int i=rowStart; i<rowEnd; i++) {
            for(int j=colStart; j<colEnd; j++) {
                if(grid[i][j] == 1) one = true;
                else if(grid[i][j] == 0) zero = true;
                if(one && zero) {
                    node.topLeft = construct(grid, rowStart, rowStart + (rowEnd-rowStart)/2, colStart, colStart + (colEnd-colStart)/2, new Node());
                    node.topRight = construct(grid, rowStart, rowStart + (rowEnd-rowStart)/2, colStart + (colEnd-colStart)/2, colEnd, new Node());
                    node.bottomLeft = construct(grid, rowStart + (rowEnd-rowStart)/2, rowEnd, colStart, colStart + (colEnd-colStart)/2, new Node());
                    node.bottomRight = construct(grid, rowStart + (rowEnd-rowStart)/2, rowEnd, colStart + (colEnd-colStart)/2, colEnd, new Node());
                    return node;
                }
            }
        }
        node.isLeaf = true;
        node.val = one ? true : false;
        return node;
        
    }
    public Node construct(int[][] grid) {
        Node root = new Node();
        int n = grid.length;
        return construct(grid, 0, n, 0, n, root);
    }
}