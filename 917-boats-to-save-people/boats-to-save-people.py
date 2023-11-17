class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        ans, left, right = 0, 0, len(people)-1
        people.sort()
        while left <= right:
            if people[left] + people[right] <= limit:
                left += 1
            right -= 1
            ans += 1
        return ans
