/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var getCommon = function(nums1, nums2) {
    let f = 0;
    let s = 0;
    while(f < nums1.length && s < nums2.length) {
        if(nums1[f] === nums2[s]) return nums1[f];
        else if(nums1[f] < nums2[s]) f++;
        else s++;
    }
    return -1;
};