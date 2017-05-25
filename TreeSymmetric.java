/* Given a binary tree t, determine whether it is 
	symmetric around its center, i.e. each side mirrors the other.*/
	// Definition for binary tree:
	// class Tree<T> {
	//   Tree(T x) {
	//     value = x;
	//   }
	//   T value;
	//   Tree<T> left;
	//   Tree<T> right;
	// }
class TreeSymmetric {
	boolean isTreeSymmetric(Tree<Integer> t) {
	  if(t == null)
	    return true;
	  return isTreeSymmetricUtil(t,t);
	}
	boolean isTreeSymmetricUtil(Tree<Integer> l, Tree<Integer> r) {
	  if ((l == null) && (r == null))
	    return true;
	  if(l != null && r != null && l.value.intValue() == r.value.intValue())
	    return (isTreeSymmetricUtil(l.left, r.right) && isTreeSymmetricUtil(l.right, r.left));
	  return false;  
	}
}