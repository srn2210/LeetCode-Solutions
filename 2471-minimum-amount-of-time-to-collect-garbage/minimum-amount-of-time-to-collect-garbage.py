class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        g, p, m = 0, 0, 0
        tp, tg, tm = 0, 0, 0

        for i in range(len(garbage)):
            for c in garbage[i]:
                if c == 'P':
                    p += tp + 1
                    tp = 0
                elif c == 'G':
                    g += tg + 1
                    tg = 0
                else:
                    m += tm + 1
                    tm = 0
            if i == len(travel): break
            tp += travel[i]
            tg += travel[i]
            tm += travel[i]
        
        return p + g + m