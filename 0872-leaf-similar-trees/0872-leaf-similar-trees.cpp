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
    void dfs(TreeNode* node, vector<int> &list) {
        if(node == nullptr) return;
        if(node->left == nullptr && node->right == nullptr) {
            list.push_back(node->val);
            return;
        }
        dfs(node->left, list);
        dfs(node->right, list);
        return;
    }
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> s1;
        vector<int> s2;
        dfs(root1, s1);
        dfs(root2, s2);
        if(s1.size() != s2.size()) return false;
        for(int i=0; i<s1.size(); i++) {
            if(s1[i] != s2[i]) return false;
        }
        return true;
    }
};