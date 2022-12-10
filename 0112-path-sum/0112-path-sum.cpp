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
    bool flag = false;
    void dfs(TreeNode* node, int target, int sum) {
        if(!node) return;
        if(node->left == nullptr && node->right == nullptr) {
            if(sum + node->val == target) flag = true;
            return;
        }
        dfs(node->left, target, node->val + sum);
        dfs(node->right, target, node->val + sum);
        return;
    }
    bool hasPathSum(TreeNode* root, int targetSum) {
        dfs(root, targetSum, 0);
        return flag;
    }
};