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
    void dfs(TreeNode *root, vector<int> &arr) {
        if(root == nullptr) return;
        dfs(root->left, arr);
        arr.push_back(root->val);
        dfs(root->right, arr);
    }
    bool isValidBST(TreeNode* root) {
        vector<int> arr;
        dfs(root, arr);
        for(int i=1; i<arr.size(); i++) {
            if(arr[i] <= arr[i-1]) return false;
        }
        return true;
    }
};