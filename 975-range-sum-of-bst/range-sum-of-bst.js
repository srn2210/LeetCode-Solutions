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
 * @param {number} low
 * @param {number} high
 * @return {number}
 */
var rangeSumBST = function(root, low, high) {

    function solve(node) {
        if(node === null) return 0;
        let ans = 0;
        if(node.val <= high && node.val >= low) {
            ans += node.val;
            ans += solve(node.left)
            ans += solve(node.right)
        }
        else if(node.val > high) ans += solve(node.left);
        else if(node.val < low) ans += solve(node.right);
        return ans;
    }

    return solve(root);
};