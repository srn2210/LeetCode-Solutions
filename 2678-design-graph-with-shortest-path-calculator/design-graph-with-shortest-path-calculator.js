/**
 * @param {number} n
 * @param {number[][]} edges
 */
var Graph = function(n, edges) {
    this.graph = new Array(n);

    for(let i=0; i<n; i++) this.graph[i] = [];

    // let graph = this.graph;
    
    for(let [u, v, c] of edges) {
        // console.log(this.graph);
        this.graph[u].push([v, c]);
    }

};

/** 
 * @param {number[]} edge
 * @return {void}
 */
Graph.prototype.addEdge = function(edge) {
    // let graph = this.graph;

    this.graph[edge[0]].push([edge[1], edge[2]]);
};

/** 
 * @param {number} node1 
 * @param {number} node2
 * @return {number}
 */
Graph.prototype.shortestPath = function(node1, node2) {
    const heap = new MinPriorityQueue();
    heap.enqueue({node: node1, cost: 0}, 0);
    let visited = new Set();    

    while(heap.size() > 0) {
        let top = heap.dequeue().element;
        if(visited.has(top.node)) {
            continue;
        }
        visited.add(top.node);
        if(top.node === node2) {
            return top.cost;
        }
        let next = this.graph[top.node];
        for(let neigh of next) {
            heap.enqueue({node: neigh[0], cost: top.cost + neigh[1]}, top.cost + neigh[1]);
        }
    }
    return -1;
};

/** 
 * Your Graph object will be instantiated and called as such:
 * var obj = new Graph(n, edges)
 * obj.addEdge(edge)
 * var param_2 = obj.shortestPath(node1,node2)
 */