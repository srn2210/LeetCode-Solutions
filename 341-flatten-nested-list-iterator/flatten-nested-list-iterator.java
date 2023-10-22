/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> list;
    List<Integer> ansList;
    int ptr;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        ansList = new ArrayList<>();
        solve(list, 0);
        ptr = 0;
    }

    void solve(List<NestedInteger> curr, int idx) {
        for(int i=0; i<curr.size(); i++) {
            if(curr.get(i).isInteger()) {
                ansList.add(curr.get(i).getInteger());
            }
            else {
                solve(curr.get(i).getList(), 0);
            }
        }
    }

    @Override
    public Integer next() {
        return ansList.get(ptr++);
    }

    @Override
    public boolean hasNext() {
        return ptr < ansList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */