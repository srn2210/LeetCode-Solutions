/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    let st = [];
    let ans = 0;

    for(let i in heights) {
        h = heights[i];
        while(st && heights[st[st.length-1]] > h) {
            let t = st.pop();
            let prev = -1;
            if(st.length > 0) {
                prev = st[st.length-1];
            }
            ans = Math.max(ans, heights[t] * (i - prev - 1));
        }
        st.push(i);
    }
    while(st.length > 0) {
        let t = st.pop();
        let prev = -1;
        if(st.length > 0) {
            prev = st[st.length-1];
        }
        ans = Math.max(ans, heights[t] * (heights.length - prev - 1));
    }
    return ans;
};