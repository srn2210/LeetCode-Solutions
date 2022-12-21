/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* ans = nullptr;
    bool flag = true;
    bool dfs(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr) return false;
        bool left = dfs(root->left, p, q);
        bool right = dfs(root->right, p, q);
        if(((left && right) || (left && (root == p || root == q)) || (right && (root == p || root == q))) && flag) {
            cout<<root->val<<endl;
            ans = root;
            flag = false;
        }
        if(root == p || root == q) {
            return true;
        }
        return left || right;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        dfs(root, p, q);
        return ans;
    }
};