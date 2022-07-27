class MyHashMap {
    
    int[] al;
    
    public MyHashMap() {
        al = new int[16];
        Arrays.fill(al,-1);
    }
    
    public void put(int key, int value) {
        if(key >= al.length){
            int[] newarr = new int[key+1];
            Arrays.fill(newarr,al.length,newarr.length-1, -1);
            System.arraycopy(al,0,newarr,0,al.length);
            al = newarr;
        }
        al[key] = value;
    }
    
    public int get(int key) {
        if(key >= al.length){
            return -1;
        }
        return al[key];
    }
    
    public void remove(int key) {
        if(key < al.length){
            al[key] = -1;
        }
    }
}