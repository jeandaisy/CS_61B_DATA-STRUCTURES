/* DListNode.java */



public class DListNode<T> {
 public T item;
 public DListNode<T> next,prev;
  


  
/**constructor that creates a node with given field*/
  DListNode(T obj, DListNode<T> p, DListNode<T> n) {
    item = obj;
    prev = p;
    next=n;
  }

/**returns the element of this node*/
 public T getItem(){
	 return item;
 }

  public DListNode<T> getPrev() {
    return prev;
  }
  
  public DListNode<T> getNext() {
	    return next;
  }
  
  public void setItem(T newItem) {
	  item=newItem;
  }
  
  public void setPrev(DListNode<T> newPrev) {
	  prev=newPrev;
  }
  public void setNext(DListNode<T> newNext) {
	  next=newNext;
  }


public static void main(String[] args) {
    int[] i = {1,2,3};
    DListNode<int[]> node = new DListNode<int[]>(i, null, null);
    int[] j = node.item;
    for (int x = 0; x < j.length; x++) {
      System.out.println(j[x]);
    }
  }
}




/////////////////////////////////////////////////
/* DListNode.java */



/**
 *  A DListNode is a node in a DList (doubly-linked list).
 */


/*
public class DListNode<T> {

  /**
   *  item references the item stored in the current node.
   *  prev references the previous node in the DList.
   *  next references the next node in the DList.
   */
/*
  public T item;
  public DListNode<T> prev;
  public DListNode<T> next;
  public DList<T> lst;

  /**
   *  DListNode() constructor.
   *  @param i the item to store in the node.
   *  @param p the node previous to this node.
   *  @param n the node following this node.
   */
/*
  DListNode(T i, DListNode<T> p, DListNode<T> n) {
    this(i, p, n, null);
  }

  /**
   *  DListNode() constructor.
   *  @param i the item to store in the node.
   *  @param p the node previous to this node.
   *  @param n the node following this node.
   *  @param l the list node belongs to.
   */

/*
  DListNode(T i, DListNode<T> p, DListNode<T> n, DList<T> l) {
  item = i;
    prev = p;
    next = n;
    lst = l;
  }

  public static void main(String[] args) {
    int[] i = {1,2,3};
    DListNode<int[]> node = new DListNode<int[]>(i, null, null);
    int[] j = node.item;
    for (int x = 0; x < j.length; x++) {
      System.out.println(j[x]);
    }
  }
}
*/