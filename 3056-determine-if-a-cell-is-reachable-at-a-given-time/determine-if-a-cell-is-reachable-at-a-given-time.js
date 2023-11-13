/**
 * @param {number} sx
 * @param {number} sy
 * @param {number} fx
 * @param {number} fy
 * @param {number} t
 * @return {boolean}
 */
var isReachableAtTime = function(sx, sy, fx, fy, t) {
    if(sx === fx && sy === fy && t === 1) return false;
    return Math.max(Math.abs(fx-sx), Math.abs(fy-sy)) <= t;
};