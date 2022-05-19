class key{
    public int index;
    public boolean buy;
    public int hashCode;
    public key(int index, boolean buy){
        this.index = index;
        this.buy = buy;
        this.hashCode = Objects.hash(index, buy);
    }
    @Override
    public int hashCode() {
        return this.hashCode;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        key that = (key) o;
        return index == that.index && buy == that.buy;
    }
}


class Solution {
    int profit (HashMap<key, Integer> cache, int[] prices, int index, boolean buying){
        if(index >= prices.length){
            return 0;
        }
        key newKey = new key(index, buying);
        if(cache.containsKey(newKey)) return cache.get(newKey);
        if(buying){
            cache.put(newKey, Math.max(profit(cache, prices, index + 1, buying), profit(cache, prices, index + 1, !buying) - prices[index]));
        } else{
            cache.put(newKey, Math.max(profit(cache, prices, index + 1, buying), profit(cache, prices, index + 2, !buying) + prices[index]));
        }
        return cache.get(newKey);
    }
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        return profit(new HashMap<>(), prices, 0, true);
    }
}