class Solution {
public:
    vector<int> tree;
    int n = INT_MIN;
    void update(int i) {
        for(int j=i; j<=n; j+=(j&-j)){
            tree[j]++;
        }
    }
    int query(int i) {
        int ans = 0;
        for(int j=i; j>0; j-= j&-j) {
            ans += tree[j];
        }
        return ans;
    }
    void reverse(vector<int>& ans) {
        int l = 0;
        int r = ans.size()-1;
        while(l < r) {
            swap(ans[l++], ans[r--]);
        }
    }
    vector<int> countSmaller(vector<int>& nums) {
        for(int i:nums) n = max(n, i);
        n += 100001;
        tree.resize(n+1);
        tree.assign(tree.size(), 0);
        vector<int> ans;
        for(int i=nums.size()-1; i>=0; i--) {
            int x = nums[i] + 100001;
            ans.push_back(query(x-1));
            update(x);
        }
        reverse(ans);
        return ans;
    }
};