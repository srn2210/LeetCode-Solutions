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
    int idx = 0;
    TreeNode* solve(vector<int>& arr, unordered_map<int, int>& map, int lo, int hi) {
        if(idx >= arr.size() || lo > hi) return nullptr;
        int t = arr[idx];
        TreeNode* node = new TreeNode(t);
        idx++;
        node->left = solve(arr, map, lo, map[t]-1);
        node->right = solve(arr, map, map[t]+1, hi);
        return node;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> map;
        for(int i=0; i<inorder.size(); i++) {
            map[inorder[i]] = i;
        }
        return solve(preorder, map, 0, preorder.size()-1);
    }
};