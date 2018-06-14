package list;

public class LockDListNode extends DListNode{
	private boolean locked;
	
	
	
	public LockDListNode(Object i, DListNode p, DListNode n){
		super(i,p,n);
	}
	
	public boolean getter() {
		return locked;
	}
	
	public void setter() {
		locked=true;
	}

}
