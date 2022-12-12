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
    /*bool find(TreeNode* root, TreeNode* node, int k) {
        if(!root || root == node) return false;
        if(node->val == k) return true;
        else if(node->val < k) return find(root->right, k);
        else return find(root->left, k);
        return false;
    }
    bool dfs(TreeNode* root, TreeNode* node, int k) {
        if(!node) return false;
        int target = k - node->val;
        if(find(root, node, target)) return true;
        if(dfs(root, node->left, k)) return true;
        if(dfs(root, node->right, k)) return true;
        return false;
    }
    bool findTarget(TreeNode* root, int k) {
        return dfs(root, root, k);
    }*/
    void dfs(TreeNode* node, unordered_map<int, int>& map) {
        if(!node) return;
        map[node->val]++;
        dfs(node->left, map);
        dfs(node->right, map);
    }
    bool dfs2(TreeNode* node, unordered_map<int, int>& map, int target) {
        if(!node) return false;
        if(dfs2(node->left, map, target)) return true;
        if(dfs2(node->right, map, target)) return true;
        if(map[target - node->val] > 0) {
            if(node->val == target - node->val) return map[target - node->val] > 1;
            return true;
        }
        return false;
    }
    bool findTarget(TreeNode* root, int k) {
        unordered_map<int, int> map;
        dfs(root, map);
        return dfs2(root, map, k);
    }
};