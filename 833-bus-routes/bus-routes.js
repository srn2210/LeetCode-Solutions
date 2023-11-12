/**
 * @param {number[][]} routes
 * @param {number} source
 * @param {number} target
 * @return {number}
 */
var numBusesToDestination = function(routes, source, target) {
    let q = new Queue();
    let set = new Set();
    let map = new Map();
    let vis = new Set();
    
    for(let i=0; i<routes.length; i++) {
        for(let stop of routes[i]) {
            if(!map.has(stop)) map.set(stop, []);
            map.get(stop).push(i);
        }
    }

    q.enqueue(source);
    set.add(source);
    let ans = 0;

    while(q.size() > 0) {
        let size = q.size();
        //console.log(q);
        for(let s=0; s<size; s++) {
            let curr = q.dequeue();
            if(curr === target) return ans;
            for(let bus of map.get(curr)) {
                if(vis.has(bus)) continue;
                vis.add(bus);
                for(let stop of routes[bus]) {
                    if(!set.has(stop)) {
                        set.add(stop);
                        q.enqueue(stop);
                    }
                }
            }
        }
        ans++;
    }

    return -1;
};