/**
 * @param {number[]} arr
 * @return {number}
 */
var numFactoredBinaryTrees = function(arr) {
    
    mod = 1e9+7
    arr.sort(function (a,b) {return a - b})

    let map = new Set()

    for(let i=0; i<arr.length; i++) {
        map.add(arr[i])
    }

    let dp = new Map()

    function solve(val) {
        if(dp.has(val)) return dp.get(val)
        ans = 1
        for(let i=0; i<arr.length; i++) {
            if(val % arr[i] === 0 && map.has(val/arr[i])) {
                ans += solve(arr[i]) * solve(val/arr[i])
                ans %= mod
            }
        }
        dp.set(val, ans)
        return ans
    }

    ans = 0
    for(let i=0; i<arr.length; i++) {
        ans += solve(arr[i])
        ans %= mod
    }
    return ans
};