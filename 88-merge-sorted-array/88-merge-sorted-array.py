class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i = m-1
        j = n-1
        k = i+j+1
        while j >= 0:
            k = i+j+1
            if i >= 0 and nums1[i] > nums2[j]:
                nums1[i],nums1[k] = nums1[k],nums1[i]
                i -= 1
            else:
                nums1[k],nums2[j] = nums2[j],nums1[k]
                j -= 1