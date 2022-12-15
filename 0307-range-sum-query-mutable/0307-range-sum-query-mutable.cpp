class NumArray {
public:
    vector<int> arr;
    vector<int> bit;
    NumArray(vector<int>& nums) {
        for(int i=0; i<nums.size(); i++) {
            arr.push_back(nums[i]);
            bit.push_back(0);
        }
        bit.push_back(0);
        for(int i=0; i<nums.size(); i++) {
            update1(i+1, nums[i]);
        }
    }
    
    void update1(int index, int val) {
        for(int i = index; i<=arr.size(); i += (i & -i)) {
            bit[i] += val;
        }
    }
    
    void update(int index, int val) {
        update1(index+1, val - arr[index]);
        arr[index] = val;
    }
    
    int sum(int i) {
        int ans = 0;
        for(int j = i; j>0; j -= (j & -j)) {
            ans += bit[j];
        }
        return ans;
    }
    
    int sumRange(int left, int right) {
        return sum(right+1) - sum(left);
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */