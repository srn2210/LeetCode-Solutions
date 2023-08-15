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
    void bubbleUp(int idx) {
        while(idx != 0) {
            int par = parent(idx);
            int curr = arr.get(idx);
            int parVal = arr.get(par);
            if(parVal > curr) {
                swap(par, idx);
                idx = par;
            }
            else break;
        }
    }
    void bubbleDown(int num) {
        while(num < arr.size()) {
            int left = left(num);
            int right = right(num);
            int idx = num;
            int curr = arr.get(num);
            int leftVal = left < arr.size() ? arr.get(left) : (int)1e9;
            int rightVal = right < arr.size() ? arr.get(right) : (int)1e9;
            if(leftVal < curr) {
                curr = leftVal;
                idx = left;
            }
            if(rightVal < curr) {
                idx = right;
            }
            if(idx != num) {
                swap(idx, num);
                num = idx;
            }
            else break;
        }
    }
    void add(int num) {
        arr.add(num);
        int last = arr.size()-1;
        bubbleUp(last);
    }
    int remove() {
        int ans = arr.get(0);
        swap(0, arr.size()-1);
        arr.remove(arr.size()-1);
        bubbleDown(0);
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
        for(int num : nums) pq.arr.add(num);
        for(int i=nums.length/2-1; i>=0; i--) pq.bubbleDown(i);
        int i = 0;
        while(!pq.empty()) nums[i++] = pq.remove();
        return nums;
    }
}