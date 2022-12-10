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
    long dfs(TreeNode* node, vector<long>& arr) {
        if(node == nullptr) return 0;
        long sum = 0;
        sum += dfs(node->left, arr);
        sum += dfs(node->right, arr);
        sum += node->val;
        arr.push_back(sum);
        return sum;
    }
    int maxProduct(TreeNode* root) {
        vector<long> arr;
        dfs(root, arr);
        int n = arr.size();
        long prod = 1;
        for(int i=0; i<n-1; i++) {
            prod = max(prod, arr[i] * (arr[n-1] - arr[i]));
        }
        prod %= 1000000007;
        return (int) prod;
    }
};