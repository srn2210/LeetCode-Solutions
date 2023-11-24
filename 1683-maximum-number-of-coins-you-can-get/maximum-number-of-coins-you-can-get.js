/**
 * @param {number[]} piles
 * @return {number}
 */
var maxCoins = function(piles) {
    piles.sort((a,b) => a-b);

    let itr = piles.length / 3, ans = 0;
    let ptr = piles.length-2;
    while(itr--) {
        ans += piles[ptr];
        ptr -= 2;
    }
    return ans;
};