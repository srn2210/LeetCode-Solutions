/**
 * @param {string[]} garbage
 * @param {number[]} travel
 * @return {number}
 */
var garbageCollection = function(garbage, travel) {
    let p = 0, g = 0, m = 0;
    let tp = 0, tg = 0, tm = 0;
    for(let ig=0; ig<garbage.length; ig++) {
        for(let c of garbage[ig]) {
            if(c === 'P') {
                p += tp;
                p++;
                tp = 0;
            }
            else if(c === 'G') {
                g += tg;
                g++
                tg = 0;
            }
            else {
                m += tm;
                m++;
                tm = 0;
            }
        }
        if(ig === travel.length) break;
        tp += travel[ig];
        tm += travel[ig];
        tg += travel[ig];
    }
    return p + g + m;
};