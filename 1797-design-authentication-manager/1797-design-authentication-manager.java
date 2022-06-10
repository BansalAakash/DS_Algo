class AuthenticationManager {
    HashMap<String, Integer> map;
    TreeMap<Integer, String> time_map;
    int ttl;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<String, Integer>();
        time_map = new TreeMap<>();
        ttl = timeToLive;
    }
    public void generate(String tokenId, int currentTime) {
        clean(currentTime);
        map.put(tokenId, currentTime + ttl);
        time_map.put(currentTime + ttl, tokenId);
    }
    
    public void renew(String tokenId, int currentTime) {
        clean(currentTime);
        if(map.containsKey(tokenId)){
            time_map.remove(map.get(tokenId));
            time_map.put(currentTime + ttl, tokenId);
            map.put(tokenId, currentTime + ttl);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        clean(currentTime);
        return map.size();
    }
    
    void clean(int currentTime){
        Iterator<Map.Entry<Integer, String>> it = time_map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> entry = it.next();
            if(entry.getKey() > currentTime)
                break;
            map.remove(entry.getValue());
            it.remove();
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */