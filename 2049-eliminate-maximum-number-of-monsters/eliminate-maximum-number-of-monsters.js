/**
 * @param {number[]} dist
 * @param {number[]} speed
 * @return {number}
 */
var eliminateMaximum = function(dist, speed) {
    let time = [];
    let n = dist.length;
    for(let i=0; i<n; i++) {
        time.push(dist[i]/speed[i]);
    }
    time.sort((a,b) => a-b);
    for(let i=0; i<n; i++) {
        if(i >= time[i]) return i;
    }
    return n;
};