/* 
Given an array a, find the greatest number in a that is 
a product of two elements in a. If there are no two 
elements in a that can be multiplied to produce another
element contained in a, return -1.
*/

int maxPairProduct(int[] a) {
    int maxNumber = -1;
    if(a == null || a.length <= 2)
        return maxNumber;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < a.length; i++) {
        set.add(a[i]);
        if(map.containsKey(a[i])) {
            int value = map.get(a[i]);
            map.put(a[i], ++value);
        }
        else{
            map.put(a[i], 1);
        }
    }
    System.out.println(set);
    Integer[] array = set.toArray(new Integer[set.size()]);
    Arrays.sort(array);
    for (int i = array.length - 1; i > 0; i--) 
        for (int j = 0; j < i && array[j] <= Math.sqrt(array[i]); j++)
            if(array[i] % array[j] == 0) {
                int result = array[i] / array[j];
                System.out.println(array[i] + " " + array[j]);
                if(map.containsKey(result)) {
                    if((result == array[j] && 
                        (map.get(array[j]) > 1)) || (result != array[j]))
                        return array[i];
                }
            }
    return maxNumber;
}
