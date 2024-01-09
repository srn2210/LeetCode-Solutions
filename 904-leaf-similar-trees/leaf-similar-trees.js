/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
    let list1 = [];
    let list2 = [];
    function dfs(list, node) {
        if(node === null) return;
        if(node.left === null && node.right === null) {
            list.push(node.val);
            return;
        }
        dfs(list, node.left);
        dfs(list, node.right);
    }

    dfs(list1, root1);
    dfs(list2, root2);

    if(list1.length != list2.length) return false;
    for(let i=0; i<list1.length; i++) {
        if(list1[i] != list2[i]) return false;
    }
    return true;
};