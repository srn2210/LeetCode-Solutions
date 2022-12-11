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
    int ans = INT_MIN;
    int dfs(TreeNode* node) {
        if(!node) return 0;
        int sum = node->val;
        int left = dfs(node->left);
        int right = dfs(node->right);
        ans = max(ans, sum);
        ans = max(ans, left + sum);
        ans = max(ans, right + sum);
        ans = max(ans, sum + left + right);
        int t = max(left + sum, right + sum);
        t = max(t, sum);
        return t;
    }
    int maxPathSum(TreeNode* root) {
        dfs(root);
        return ans;
    }
};