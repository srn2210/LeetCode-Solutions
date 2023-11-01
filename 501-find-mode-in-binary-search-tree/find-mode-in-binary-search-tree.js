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
 * @return {number[]}
 */
var findMode = function(root) {
    let max = 0;
    const map = new Map();
    const ans = [];

    function dfs(node) {
        if(node === null) return node;
        count = 0;
        if(map.has(node.val)) count = map.get(node.val);
        map.set(node.val, count+1);
        max = Math.max(max, map.get(node.val));
        dfs(node.left);
        dfs(node.right);
    }

    dfs(root);

    //console.log(map);

    for(pair of map.entries()) {
        if(pair[1] == max) {
            ans.push(pair[0]);
        }
    }

    return ans;
};