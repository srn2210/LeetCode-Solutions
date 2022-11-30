class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        hmap = defaultdict(int)
        for i in arr :
            hmap[i] += 1
        hset = set()
        for i, j in hmap.items() :
            if j in hset : return False
            else : hset.add(j)
        return True