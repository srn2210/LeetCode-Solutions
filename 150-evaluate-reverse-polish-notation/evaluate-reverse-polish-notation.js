/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    let list = [];

    for(let token of tokens) {
        if(token === '+') {
            let second = list.pop();
            let first = list.pop();
            let third = first + second;
            list.push(third);
        }
        else if(token === '-') {
            let second = list.pop();
            let first = list.pop();
            list.push(first-second);
        }
        else if(token === '*') {
            let second = list.pop();
            let first = list.pop();
            list.push(first*second);
        }
        else if(token === '/') {
            let second = list.pop();
            let first = list.pop();
            let res = Math.trunc(first / second);
            list.push(res);
        }
        else {
            list.push(token*1);
        }
    }
    return list.pop();
};