public class Heap {
    List<Integer> arr;
    Heap() {
        arr = new ArrayList<>();
    }
    int parent(int num) {
        return (num-1)/2;
    }
    int left(int num) {
        return (2 * num) + 1;
    }
    int right(int num) {
        return (2 * num) + 2;
    }
    void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    void add(int num) {
        arr.add(num);
        int last = arr.size()-1;
        while(last != 0) {
            int par = parent(last);
            int parVal = arr.get(par);
            int curr = arr.get(last);
            if(parVal > curr) {
                swap(par, last);
                last = par;
            }
            else break;
        }
    }
    int remove() {
        int ans = arr.get(0);
        swap(0, arr.size()-1);
        arr.remove(arr.size()-1);
        int idx = 0;
        while(idx < arr.size()) {
            int left = left(idx);
            int right = right(idx);
            int curr = arr.get(idx);
            int ind = idx;
            int leftVal = left < arr.size() ? arr.get(left) : (int)1e9;
            int rightVal = right < arr.size() ? arr.get(right) : (int)1e9;
            if(leftVal < curr) {
                curr = leftVal;
                ind = left;
            }
            if(rightVal < curr) {
                ind = right;
                curr = rightVal;
            }
            if(idx != ind) {
                swap(idx, ind);
                idx = ind;
            }
            else break;
        }
        return ans;
    }
    int peek() {
        return arr.get(0);
    }
    int size() {
        return arr.size();
    }
    boolean empty() {
        return size() == 0;
    }
    public String toString() {
        return arr.toString();
    }
}
class Solution {
    public int[] sortArray(int[] nums) {
        Heap pq = new Heap();
        for(int num : nums) pq.add(num);
        int i = 0;
        while(!pq.empty()) nums[i++] = pq.remove();
        return nums;
    }
}