/**
 * @param {number} n
 * @param {number[][]} flights
 * @param {number} src
 * @param {number} dst
 * @param {number} k
 * @return {number}
 */
var findCheapestPrice = function(n, flights, src, dst, k) {
    let arr = new Array(n).fill(Infinity);

    arr[src] = 0;

    for(let j=0; j<=k; j++) {
        let temp = new Array(n);
        for(let i=0; i<n; i++) {
            temp[i] = arr[i];
        }
        for(let [s, d, c] of flights) {
            if(arr[s] + c < arr[d]) {
                temp[d] = Math.min(temp[d], arr[s] + c);
            }
        }
        arr = temp;
    }

    return arr[dst] === Infinity ? -1 : arr[dst];
};