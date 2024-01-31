/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    let st = [];
    let ans = new Array(temperatures.length).fill(0);

    for(let i=0; i<temperatures.length; i++) {
        while(st.length != 0 && temperatures[st[st.length-1]] < temperatures[i]) {
            let last = st.pop();
            ans[last] = i - last;
        }
        st.push(i);
    }
    return ans;
};