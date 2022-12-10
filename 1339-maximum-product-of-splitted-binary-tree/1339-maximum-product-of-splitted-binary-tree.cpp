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
    long ans = 0;
    long dfs(TreeNode* node) {
        if(node == nullptr) return 0;
        long sum = 0;
        sum += dfs(node->left);
        sum += node->val;
        sum += dfs(node->right);
        return sum;
    }
    long dfs(TreeNode* node, long total) {
        if(node == nullptr) return 0;
        long sum = 0;
        sum += dfs(node->left, total);
        sum += dfs(node->right, total);
        sum += node->val;
        ans = max(ans, sum * (total - sum));
        return sum;
    }
    int maxProduct(TreeNode* root) {
        long sum = dfs(root);
        dfs(root, sum);
        ans %= 1000000007;
        return (int) ans;
    }
};