
/* All DNA is composed of a series of nucleotides 
abbreviated as A, C, G, and T. In research, 
it can be useful to identify repeated sequences within DNA.
Write a function to find all the 10-letter sequences (substrings) 
that occur more than once in a DNA molecule s, and return them in 
lexicographical order. These sequences can overlap.
*/

String[] repeatedDNASequences(String s) {
     Map<String, Integer> map = new HashMap<String, Integer>();
     for(int i = 0; i <= s.length() - 10; i++) {
          StringBuilder subsequence = new StringBuilder();
          for(int j = i; j < i + 10; j++)
               subsequence.append(s.charAt(j));
          if(map.containsKey(subsequence.toString())) {
               int value = map.get(subsequence.toString()) + 1;
               map.put(subsequence.toString(), value);
          }
          else
               map.put(subsequence.toString(), 1);
     }
     int count = 0;
     System.out.println(map);
     for(Map.Entry<String, Integer> pair : map.entrySet()) {
          if(pair.getValue() > 1)
              count++; 
     } 
     String [] result = new String[count];
     int i = 0;
     for(Map.Entry<String, Integer> pair : map.entrySet()) {
          if(pair.getValue() > 1) {
               result[i] = pair.getKey();
               i++;
          }
     } 
     Arrays.sort(result);
     return result;
}
