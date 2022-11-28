class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        unordered_set<int> won;
        unordered_set<int> loss;
        unordered_set<int> more;
        vector<vector<int>> res;
        for(auto arr : matches) {
            if(loss.count(arr[1]) || more.count(arr[1]) ) {
                loss.erase(arr[1]);
                more.insert(arr[1]);
            }
            else{
                loss.insert(arr[1]);
                if(won.count(arr[1])) won.erase(arr[1]);
            }
            if(!loss.count(arr[0]) && !more.count(arr[0])) {
                won.insert(arr[0]);
            }
        }
        vector<int> t1(won.begin(), won.end());
        vector<int> t2(loss.begin(), loss.end());
        sort(t1.begin(), t1.end());
        sort(t2.begin(), t2.end());
        res.push_back(t1);
        res.push_back(t2);
        return res;
    }
};