/**
 * @param {number[]} arr
 * @return {number}
 */
var findSpecialInteger = function(arr) {
    let cand1 = arr[Math.round(arr.length/4)], cand2 = arr[Math.round(3 * (arr.length/4))], cand3 = arr[Math.round(arr.length/2)];

    //console.log(cand1 + "  " + cand2 + "  " + cand3);
    let solve = (cand) => {
        let left = 0, right = arr.length-1;
        while(left < right) {
            let mid = (right + left) / 2;
            // mid = Math.round(mid);
            mid = mid - (mid % 1);
            if(arr[mid] >= cand) right = mid;
            else left = mid + 1;
        }
        let leftMost = left;
        //console.log(leftMost);
        left = 0;
        right = arr.length-1;
        while(left < right) {
            let mid = (right + left) / 2 + 1;
            mid = mid - (mid % 1);
            if(arr[mid] <= cand) left = mid;
            else right = mid - 1;
        }
        let rightMost = right;
        return rightMost - leftMost + 1 > arr.length / 4;
    }
    if(solve(cand1)) return cand1;
    else if(solve(cand2)) return cand2;
    else return cand3;
};