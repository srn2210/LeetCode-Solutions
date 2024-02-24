class Solution {
    class UF {
        int[] arr;
        int[] sz;
        UF(int n) {
            arr = new int[n];
            sz = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                sz[i] = 1;
            }
        }
        int find(int p) {
            if(p == arr[p]) return p;
            else return arr[p] = find(arr[p]);
        }
        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(isConnected(x, y)) return;
            else {
                if(sz[x] > sz[y]) {
                    sz[x] += sz[y];
                    arr[y] = x;
                }
                else {
                    sz[y] += sz[x];
                    arr[x] = y;
                }
            }
        }
        void disconnect(int p, int q) {
            arr[p] = p;
            sz[p] = 1;

            arr[q] = q;
            sz[q] = 1;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int m = meetings.length;
        UF og = new UF(n);
        og.union(0, firstPerson);
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[2], b[2]));
        for(int i=0; i<m; i++) {
            int time = meetings[i][2];
            int j = i;
            while(j < m && meetings[j][2] == time) {
                int src = meetings[j][0];
                int dst = meetings[j][1];
                og.union(src, dst);
                j++;
            }

            for(int k=i; k<j; k++) {
                int src = meetings[k][0];
                int dst = meetings[k][1];
                if(!og.isConnected(src, 0)) {
                    og.disconnect(src, dst);
                }
            }

            i = j-1;
        }
        var ans = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            if(og.isConnected(0, i)) ans.add(i);
        }
        return ans;
    }
}