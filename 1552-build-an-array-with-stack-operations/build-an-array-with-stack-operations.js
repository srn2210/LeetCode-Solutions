/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function(target, n) {
    const ans = [];
    let ptr = 0;

    for(let i=1; i<=n; i++) {
        if(ptr === target.length) break;
        else if(target[ptr] === i) {
            ans.push("Push");
            ptr++;
        }
        else {
            ans.push("Push");
            ans.push("Pop");
        }
    }

    return ans;
};