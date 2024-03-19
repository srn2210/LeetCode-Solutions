/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
var leastInterval = function(tasks, n) {
    let pq = new PriorityQueue({ compare: (a,b) => b[0]-a[0]});
    let map = new Map();
    let arr = [];
    for(let i=0; i<26; i++) arr.push([0, i]);
    for(let task of tasks) {
        arr[task.charCodeAt(0)-'A'.charCodeAt(0)][0]++;
    }
    for(let a of arr) {
        if(a[0] != 0) pq.enqueue(a);
    }
    let time = 0;
    while(!pq.isEmpty() || map.size !== 0) {
        if(map.has(time)) {
            // console.log(map.get(time));
            pq.enqueue(map.get(time));
            map.delete(time);
        }
        if(!pq.isEmpty()) {
            let tt = pq.dequeue();
            if(tt[0] != 1) {
                tt[0]--;
                map.set(time+n+1, tt);
                // console.log(map);
            }
        }
        time++;
    }

    return time;
};