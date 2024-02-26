/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
    
    function dfs(x, y) {
        if(x === null && y === null) return true;
        if((x === null && y !== null) || (x !== null && y === null)) return false;
        if(x.val != y.val) return false;
        return dfs(x.left, y.left) && dfs(x.right, y.right);
    }

    return dfs(p, q);
};