/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int dfs(TreeNode* node, int min, int max) {
        if(node == nullptr) return abs(max - min);
        if(node->val < min) min = node->val;
        if(node->val > max) max = node->val;
        int a = dfs(node->left, min, max);
        int b = dfs(node->right, min, max);
        return a > b ? a : b;
    }
    int maxAncestorDiff(TreeNode* root) {
        return dfs(root, INT_MAX, INT_MIN);
    }
};