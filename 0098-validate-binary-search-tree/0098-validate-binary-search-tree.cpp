class Solution {
public:
    bool dfs(TreeNode *root, long max, long min) {
        if(!root) return true;
        if(!dfs(root->left, root->val, min)) return false;
        if(root->val >= max || root->val <= min) return false;
        if(!dfs(root->right, max, root->val)) return false;
        return true;
    }
    bool isValidBST(TreeNode* root) {
        return dfs(root, (long)INT_MAX+1, (long)INT_MIN-1);
    }
};