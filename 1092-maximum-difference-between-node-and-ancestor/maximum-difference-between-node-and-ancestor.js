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
var maxAncestorDiff = function(root) {
    let ans = -1;
    function dfs(ancMin, ancMax, node) {
        if(node === null) return 0;
        ans = Math.max(ans, Math.abs(ancMin-node.val));
        ans = Math.max(ans, Math.abs(ancMax-node.val));
        dfs(Math.min(ancMin, node.val), Math.max(ancMax, node.val), node.left);
        dfs(Math.min(ancMin, node.val), Math.max(ancMax, node.val), node.right);
    }
    dfs(root.val, root.val, root);
    return ans;
};