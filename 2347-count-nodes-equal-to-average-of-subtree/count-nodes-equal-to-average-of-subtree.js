/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var averageOfSubtree = function(root) {
    let ans = 0;

    function dfs(node) {
        if(node === null) return [0, 0];
        let left = dfs(node.left);
        let right = dfs(node.right);
        let sum = left[0] + right[0] + node.val;
        let nodes = left[1] + right[1] + 1;
        if(Math.floor(sum / nodes) === node.val) ans++;
        return [sum, nodes];
    }

    dfs(root);

    return ans;
};