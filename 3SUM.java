import java.util.*;
/*Given an array S of n integers, are there elements a, b, c in S such 
that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
*/
class 3SUM
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] nums = {-4, -2, -2, -2, 0, 2, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
		List<List<Integer>> answer = threeSum(nums);
		for(List<Integer> list: answer) {
		    for (Integer i: list) {
		        System.out.print(i + " ");
		    }
		    System.out.println();
		}
	}
	
	class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public String toString() {
            return "[" + i +" , "+ j + "]";
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>(); // result list
        Set<Integer> s = new HashSet<Integer>(); // set of unique symbols in the array
        if(nums == null || (nums.length >= 0 && nums.length < 3)) {
            return list;
        }
        Arrays.sort(nums);
        for(Integer k: nums) {
            s.add(k);
        }
        // map(key: (nums[i] - nums[j]), value: list of indexes)
        Map<Integer, List<Pair>> twoElementsSums = new HashMap<Integer, List<Pair>>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                int sum = nums[i] + nums[j];
                if(s.contains(-sum)){ 
                    if(!twoElementsSums.containsKey(sum)) { 
                        List<Pair> pairs = new LinkedList<Pair>();
                        pairs.add(new Pair(i,j));
                        twoElementsSums.put(sum, pairs);
                    }
                    else {
                        List<Pair> pairs = twoElementsSums.get(nums[i] + nums[j]);
                        pairs.add(new Pair(i,j));
                        twoElementsSums.put(sum, pairs);
                    }
                }
                while((j + 1) < nums.length && nums[j] == nums[j + 1])
                       j++;
            }
            while((i + 1) < nums.length && nums[i] == nums[i + 1])
                   i++;
        }
        Set<List<Integer>> set = new HashSet<List<Integer>>(); // Set of triples
        for (int i = 2; i < nums.length; i++) {
            while((i + 1) < nums.length && nums[i] == nums[i+1])
                i++;
            if(twoElementsSums.containsKey(-nums[i])) {
                List<Pair> value =  twoElementsSums.get(-nums[i]);
                for (Pair p: value) {
                    if(p.i < p.j && p.j < i) {
                        List<Integer> innerList = new LinkedList<Integer>();
              	        innerList.add(nums[p.i]);
              	        innerList.add(nums[p.j]);
              	        innerList.add(nums[i]);
                        set.add(innerList);
                    }
                }
            }
        }
        for (List<Integer> l: set) {
            list.add(l);
        }
     return  list;
    }
}