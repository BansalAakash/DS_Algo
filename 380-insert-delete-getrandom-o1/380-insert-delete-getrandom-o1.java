class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    int index;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        index = 0;                        //store the index of the last elem
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) 
            return false;
        map.put(val, index++);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int i = map.get(val);               //get index of elem to be deleted
        int temp = list.get(index - 1);         //get last elem of the list
        list.set(i, temp);                  //replace elem to be deleted with last elem
        list.remove(index - 1);                 //remove last elem from last
        map.put(temp, i);                   //update the index of last elem to the index of the elem to be deleted
        map.remove(val);                    //remove the elem to be deleted from map
        index--;
        return true;
    }
    public int getRandom() {
        return list.get(ThreadLocalRandom.current().nextInt(0, index));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */