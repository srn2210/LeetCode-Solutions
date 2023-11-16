class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        s = set()
        for num in nums:
            s.add(int(num, 2))
        for i in range(len(nums)+1):
            if i not in s:
                return '{0:{fill}{size}b}'.format(i, fill='0', size=len(nums))
        return ''