/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthFactor = function(n, k) {
    let fac = [];
    let fac2 = [];
    for(let i=1; i*i<=n; i++) {
        if(n % i == 0) {
            fac.push(i);
            if(n / i != i) fac2.push(n/i);
        }
    }
    // console.log(fac);
    // console.log(fac2);
    // console.log(k-fac.length-fac2.length);
    if(k > (fac2.length + fac.length)) return -1;
    else if(k <= fac.length) return fac[k-1];
    else return fac2[(-k+fac.length+fac2.length)];
};