class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res = []
        hmap = [0] * 1001
        for num in nums1 :
            hmap[num] += 1
        for num in nums2 :
            if hmap[num] > 0 : res.append(num)
            hmap[num] -= 1
        return res