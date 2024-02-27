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
var diameterOfBinaryTree = function(root) {
    let ans = 0;
    function dfs(node) {
        if(node === null) return -1;

        let left = 1 + dfs(node.left);
        let right = 1 + dfs(node.right);
        
        ans = Math.max(ans, left + right);

        return Math.max(left, right);
    }

    dfs(root)

    return ans;
};