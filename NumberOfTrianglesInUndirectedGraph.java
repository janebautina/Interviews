import java.io.*;
import java.util.*;



class NumberOfTrianglesInUNdirectedGraph {

  public static void main(String[] args) {

    int[][] edges = {{0,1},
                    {1,2},
                    {0,2}};
    int[][] edges2 = {{0,1}, {3,0}, {0,2}, {3,2}, {1,2}, {4,0}, {3,4}, {3,5}, {4,5}, {1,5}, {1,3}};
    //Map<Integer, ArrayList<Integer>> map = convertToMap(edges);
    System.out.println("Number result: " + findT(3,edges));
     System.out.println("Number result: " + findT(6,edges2));


  }

  //[[0,1],
  //[3,0],
  //[0,2], [3,2], [1,2], [4,0], [3,4], [3,5], [4,5], [1,5], [1,3]]

  // key, value
  // 0, 1, 3
  // 1, 0
  // 3, 0


  private static Map<Integer, ArrayList<Integer>> convertToMap(int[][] edges) {
     Map<Integer, ArrayList<Integer>> map = new HashMap<>();
     for (int row = 0; row < edges.length; row++) {
           if (map.containsKey(edges[row][0])) {
             ArrayList<Integer> list = map.get(edges[row][0]);
             list.add(edges[row][1]);
             map.put(edges[row][0], list);
           } else {
             ArrayList<Integer> list = new ArrayList<>();
             list.add(edges[row][1]);
             map.put(edges[row][0], list);
           }
           if (map.containsKey(edges[row][1])) {
             ArrayList<Integer> list = map.get(edges[row][1]);
             list.add(edges[row][0]);
             map.put(edges[row][1], list);
           } else {
              ArrayList<Integer> list = new ArrayList<>();
             list.add(edges[row][0]);
             map.put(edges[row][1], list);
           }

     }
    return map;

  }


  // 0, 2, 1
  // 1, 0, 2
  // 2, 0, 1
  //

  //0


  private static int findT(int n, int edges[][]) {
    if (n < 3) return 0;
    if (edges == null || edges.length < 3 || edges[0].length != 2) {
      return 0;
    }

    Map<Integer, ArrayList<Integer>> map = convertToMap(edges);

    int result = 0;

    for (Map.Entry<Integer,ArrayList<Integer>> entry: map.entrySet()) {
      int key = entry.getKey();//0
      ArrayList<Integer> list = entry.getValue();//1,2

      for (int i = 0; i < list.size(); i++) {
        for (int j = i + 1; j < list.size(); j++) {
          ArrayList<Integer> listCurrent = map.get(list.get(i));
          for (int k = 0; k < listCurrent.size(); k++) {
             if (listCurrent.get(k) == list.get(j)) {
                 result++;
             }
          }

        }

      }
    }
    return result/3;
  }
}
