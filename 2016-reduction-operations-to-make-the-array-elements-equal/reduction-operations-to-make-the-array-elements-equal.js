/**
 * @param {number[]} nums
 * @return {number}
 */
var reductionOperations = function(nums) {
    let ans = 0, max = 0, curr = 0;

    for(let num of nums) {
        max = Math.max(max, num);
    }
    let buckets = new Array(max+1).fill(0);

    for(let num of nums) {
        buckets[num]++;
    }

    curr = buckets[max];
    for(let i=max-1; i>=0; i--) {
        if(buckets[i]) {
            ans += curr;
            curr += buckets[i];
        }
    }
    return ans;
};