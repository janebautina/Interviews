/*
Given an array of strings s, find the number of common characters shared by all of the strings.
*/
int commonCharacterCount2(String[] s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    if(s == null || s.length == 0)
        return 0;
    for (int i = 0; i < s[0].length(); i++) {
        if(map.containsKey(s[0].charAt(i))) {
            int value = map.get(s[0].charAt(i)) + 1;
            map.put(s[0].charAt(i), value);
        }
        else 
            map.put(s[0].charAt(i), 1);
    }
    for (int i = 1; i < s.length; i++) {
        Map<Character, Integer> mapOther = new HashMap<Character, Integer>();
        for (int j = 0; j < s[i].length(); j++){
            if(mapOther.containsKey(s[i].charAt(j))) {
                int value = mapOther.get(s[i].charAt(j)) + 1;
                mapOther.put(s[i].charAt(j), value);
            }
            else 
                mapOther.put(s[i].charAt(j), 1);
        }
        map = mapsIntersection(map, mapOther);
    }
    int count = 0; // number of keys their values != 0
    Iterator<Character> itr = map.keySet().iterator();
    while (itr.hasNext()) {
        Character key = itr.next();
          count += map.get(key);
    }
    return count; 
}

Map<Character, Integer> mapsIntersection(Map<Character, Integer> map, 
                                         Map<Character, Integer> mapOther) {
    if(map.size() >= mapOther.size()) {
        return mapsIntersectionUtil(mapOther, map);
    }
    else
        return mapsIntersectionUtil(map, mapOther);  
}

Map<Character, Integer> mapsIntersectionUtil(Map<Character, Integer> map, 
                                             Map<Character, Integer> mapOther) {
    for (Map.Entry<Character, Integer> pair: map.entrySet()) {
        Character ch = pair.getKey();
        int val = pair.getValue();
        if(mapOther.containsKey(ch)) {
            int minValue = Math.min(val, mapOther.get(ch));
            map.put(ch, minValue);
        }
        else 
            map.put(ch, 0);
    }
    return map;
}
