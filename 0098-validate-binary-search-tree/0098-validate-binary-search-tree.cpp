class Solution {
public:
    bool dfs(TreeNode *root, long max, long min) {
        if(!root) return true;
        if(root->val >= max || root->val <= min) return false;
        return dfs(root->left, root->val, min) && dfs(root->right, max, root->val);
    }
    bool isValidBST(TreeNode* root) {
        return dfs(root, (long)INT_MAX+1, (long)INT_MIN-1);
    }
};