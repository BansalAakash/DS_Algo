class AuthenticationManager {
    HashMap<String, Integer> map;
    int ttl;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<String, Integer>();
        ttl = timeToLive;
    }
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + ttl);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId) && map.get(tokenId) > currentTime)
            map.put(tokenId, currentTime + ttl);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > currentTime)
                count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */