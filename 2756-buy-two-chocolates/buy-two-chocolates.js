/**
 * @param {number[]} prices
 * @param {number} money
 * @return {number}
 */
var buyChoco = function(prices, money) {
    let min1 = 1e9, min2 = 1e9;
    for(let price of prices) {
        if(price < min1) {
            min2 = min1
            min1 = price;
        }
        else if(price < min2) min2 = price;
    }
    return min1 + min2 > money ? money : money - min1 - min2;
};