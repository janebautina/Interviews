
/* Given an m x n matrix of 0s and 1s, if an element is 0, 
set its entire row and column to 0. Do it in place.
*/

import java.lang.*;
import java.util.*;
public class SetMatrixZeros {
  // arguments are passed using the text field below this editor
  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    ArrayList<Integer> list3 = new ArrayList<Integer>();
    list1.add(1);
    list1.add(1);
    list1.add(1);
    list2.add(0);
    list2.add(1);
    list2.add(1);
    list3.add(1);
    list3.add(1);
    list3.add(1);
    a.add(list1);
    a.add(list2);
    a.add(list3);
    print(a);
    setZeroes(a);
    print(a);
  }

  public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
    if( a == null || a.size() == 0 || a.get(0).size() == 0) 
      return;
    Integer firstString = 0;
    int r = 1; // zeros in first row
    for (int i = 0; i < a.get(0).size(); i++)
      r &= a.get(0).get(i);
    int c = 1; // zeros in first column
    for (int i = 0; i < a.size(); i++) 
      c &= a.get(i).get(0);
    for (int j = 0; j < a.size(); j++) {
      for (int i = 0 ; i < a.get(j).size(); i++) {
        if(a.get(j).get(i) == 0) {
          a.get(j).set(0,0);
          a.get(0).set(i,0);               
        }
      }
    }
    for (int j = 1; j < a.size(); j++) {
      for (int i = 1 ; i < a.get(j).size(); i++) {
        int temp = a.get(j).get(0) & a.get(0).get(i);
        a.get(j).set(i,temp);
      }
    }
    for (int i = 0; i < a.size(); i++) {
      int temp = a.get(i).get(0) & c;
      a.get(i).set(0, temp);
    }  
    for (int i = 0; i < a.get(0).size(); i++) {
      int temp = a.get(0).get(i) & r;
      a.get(0).set(i, temp);
    }
  }

  private static void print(ArrayList<ArrayList<Integer>> a) {
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.get(i).size(); j++) 
        System.out.print(a.get(i).get(j) + " ");
      System.out.println();
    }
  }
}