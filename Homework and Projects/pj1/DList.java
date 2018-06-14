/* SList.java */

/**
 *  The SList class is a singly-linked implementation of the linked list
 *  abstraction.  SLists are mutable data structures, which can grow at either
 *  end.
 *
 *  @author Kathy Yelick and Jonathan Shewchuk
 **/

public class DList<T> {

  private DListNode<T> header;
  private int size;
  private DListNode<T> trailer;
  /**
   *  SList() constructs an empty list.
   **/
/**Constructor that creates an empty list*/
  public DList () {
    size = 0;
    header = new DListNode<T>(null,null,null);
    trailer=new DListNode<T>(null,header,null);;
    header.setNext(trailer);
  }

  
  public DList(T item) {
	    this();
	    this.addBefore(header.next,item);
	  }
  /**
   *  isEmpty() indicates whether the list is empty.
   *  @return true if the list is empty, false otherwise.
   **/

  public boolean isEmpty() {
    return size == 0;
  }

  /**
   *  length() returns the length of this list.
   *  @return the length of this list.
   **/

  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts item "obj" at the beginning of this list.
   *  @param obj the item to be inserted.
   **/
  
  /**return the first node of the list*/
public DListNode<T> getFirst() throws IllegalStateException {
	if (isEmpty()) throw new IllegalStateException("List is empty");
	return header.getNext();	
}
 
/**return the last node of the list*/
public DListNode<T> getLast() throws IllegalStateException {
	if (isEmpty()) throw new IllegalStateException("List is empty");
	return trailer.getPrev();	
}  
 
/**return the node before the given node v, An error occurs if v is the header*/
public DListNode<T> getPrev(DListNode<T> v) throws IllegalArgumentException {
	if (v==header) throw new IllegalArgumentException("this is the header");
	return v.getPrev();	
} 

/**return the node after the given node v, An error occurs if v is the trailer*/
public DListNode<T> getNext(DListNode<T> v) throws IllegalArgumentException {
	if (v==trailer) throw new IllegalArgumentException("this is the trailer");
	return v.getNext();	
} 

/**insert the given node z before the given node v, An error occurs if v is the header*/
public void addBefore(DListNode<T> v,T item) throws IllegalArgumentException{
	DListNode<T> z=new DListNode<T>(item,v.prev,v);
	DListNode<T> u=getPrev(v);
	z.setPrev(u);
	z.setNext(v);
	v.setPrev(z);
	u.setNext(z);
	size++;
}

public void addAfter(DListNode<T> v,T item) throws IllegalArgumentException{
	DListNode<T> w=getNext(v);
	DListNode<T> z=new DListNode<T>(item,v,v.next);
	z.setPrev(v);
	z.setNext(w);
	w.setPrev(z);
	v.setNext(z);
	size++;
}

public void addFirst(T item) {
	if(this.size==0) {
		DListNode<T> v=new DListNode<T>(item,header,trailer);
		v.setPrev(header);
		v.setNext(trailer);

		header.setNext(v);
		trailer.setPrev(v);
		// size++; commented out by ZHAO, size increases twice
	}

	else {
		DListNode<T> v=new DListNode<T>(item,header,header.next);
		v.setPrev(header);
		v.setNext(header.next);
		header.setNext(v);
		(header.next.next).setPrev(v);	
	}
	size++;
	}
	


public void addLast(T item) {
	if(this.size==0) {
		DListNode<T> v=new DListNode<T>(item,header,trailer);
		v.setPrev(header);
		v.setNext(trailer);
		header.setNext(v);
		trailer.setPrev(v);
		
	}

	else {
	DListNode<T> v=new DListNode<T>(item,trailer.prev,trailer);
	v.setPrev(trailer.prev);
	v.setNext(trailer);
	(trailer.prev).setNext(v);
	(trailer).setPrev(v);
	
	
}
	size++;
}

public void remove(DListNode<T> v) {
	DListNode<T> u=getPrev(v);
	DListNode<T> w=getNext(v);
	w.setPrev(u);
	u.setNext(w);
	v.setPrev(null);
	v.setNext(null);
	size--;
}


public boolean hasPrev(DListNode<T> v) {
	return v!=header;
}

public boolean hasNext(DListNode<T> v) {
	return v!=trailer;
}

public DListNode<T> nth(int position) {
    DListNode<T> currentNode;

    if ((position < 1) || (size == 0)) {
      return null;
    } else {
      currentNode = header;
      while (position > 0) {
        currentNode = currentNode.next;
        if (currentNode == null) {
          return null;
        }
        position--;
      }
      return currentNode;
    }
  }


public String toString() {
	String s="[";
	DListNode<T> v=header.getNext();
	while(v!=trailer) {
		s+=v.getItem();
		v=v.getNext();
		if(v!=trailer)
			s+=",";
	}
	s+="]";
	return s;
	}


public static void main(String[] args) {
    System.out.println("testing");
    DList<Integer> lst = new DList<Integer>();
    System.out.println("length :"+lst.length());
    System.out.println("is empty? "+lst.isEmpty());
    System.out.println("Testing empty: " + lst);
    lst.addLast( 3);
    System.out.println("Testing add last "+lst);
    lst.addFirst(4);
    System.out.println("Testing add first "+lst);
    DListNode<Integer> first=lst.getFirst();
    lst.addAfter(first,55);
    System.out.println("Testing add after "+ lst);
    DListNode<Integer> last=lst.getLast();
    lst.addBefore(last,1000);
    //test to String
    
    System.out.println("Testing toString "+lst.toString());
    
    System.out.println("Testing add before last with 1000 "+lst);
    System.out.println("Testing first() "+lst.getFirst().item);
    System.out.println("Testing last() "+lst.getLast().item);
    // test insertAfter and insertBefore
    DListNode<Integer> midNode = lst.getFirst().next;
    lst.addBefore(midNode,999);
    System.out.println("Testing add Before of 3: "+lst);
    lst.addAfter(midNode,888);
    System.out.println("Testing add After of 3: "+lst);

   
    // test remove
    lst.remove(lst.getFirst().next);
    System.out.println("Testing remove '999': " + lst);
    
    //test nth DListNode
    DListNode<Integer> second=lst.nth(2);
    System.out.println("Testing nth: " + second.item);
    
    // test DList<int[]>
    
    String[] run = {"length", "red", "green", "blue"};
    DList<String[]> runs = new DList<String[]>(run);
    String rlst = "Testing DList<Array> : ";
    System.out.println("Testing String<array> toString"+rlst.toString());
    for (String r : runs.getFirst().item) {
      rlst += r + " ";
    }
    System.out.println(rlst);
  }
  
}




