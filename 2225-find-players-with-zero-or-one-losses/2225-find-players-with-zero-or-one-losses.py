class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        won = set()
        loss = set()
        more = set()
        for arr in matches :
            if arr[0] not in loss and arr[0] not in more :
                won.add(arr[0])
            if arr[1] in loss or arr[1] in more :
                loss.discard(arr[1])
                more.add(arr[1])
            else :
                loss.add(arr[1])
                if arr[1] in won : won.discard(arr[1])
        res = []
        res.append(list(won))
        res.append(list(loss))
        res[0].sort()
        res[1].sort()
        return res